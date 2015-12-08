package answer;

import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.*;

public class MinimumHeightTrees {
    /**
     * https://leetcode.com/problems/minimum-height-trees/
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, ArrayList<Integer>> neighbor = new HashMap<Integer, ArrayList<Integer>>();
        Map<Integer, Integer> minHeight = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; ++i) {
            neighbor.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; ++i) {
            int one = edges[i][0];
            int two = edges[i][1];
            neighbor.get(one).add(two);
            neighbor.get(two).add(one);
        }

        for (int root : neighbor.keySet()) {
            int height = 0;
            Queue<Integer> queue = new LinkedList<Integer>();
            HashSet<Integer> set = new HashSet<Integer>();
            queue.add(root);
            set.add(root);
            while (!queue.isEmpty()) {
                height ++;

                ArrayList<Integer> current = new ArrayList<Integer>();
                while (!queue.isEmpty()) {
                    current.add(queue.poll());
                }

                ArrayList<Integer> adding = new ArrayList<Integer>();
                for (int c : current) {
                    ArrayList<Integer> neighborhood = neighbor.get(c);
                    boolean flag = false;
                    for (int node : neighborhood) {
                        if (!set.contains(node)) {
                            set.add(node);
                            adding.add(node);
                            flag = true;
                        }
                    }

                    //find a leaf
                    if (!flag) {
                        if (!minHeight.containsKey(root)) {
                            minHeight.put(root, height);
                            break;
                        }
                    }
                }
                queue.addAll(adding);
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        int min = Integer.MAX_VALUE;
        for (int key : minHeight.keySet()) {
            if (min > minHeight.get(key)) {
                result.clear();
                result.add(key);
                min = minHeight.get(key);
            } else if (min == minHeight.get(key)) {
                result.add(key);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [][]edges = new int[5][2];
        edges[0] = new int[]{0,3};
        edges[1] = new int[]{1,3};
        edges[2] = new int[]{2,3};
        edges[3] = new int[]{4,3};
        edges[4] = new int[]{5,4};
        System.out.println(new MinimumHeightTrees().findMinHeightTrees(6, edges));
    }
}
