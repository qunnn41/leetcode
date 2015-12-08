package answer;

import java.util.*;

public class MinimumHeightTrees {
    /**
     * https://leetcode.com/problems/minimum-height-trees/
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Collections.singletonList(0);
        Map<Integer, List<Integer>> neighbor = new HashMap<Integer, List<Integer>>();
        List<Integer> neighborNumber = new LinkedList<Integer>();
        int[] number = new int[n];
        for (int i = 0; i < n; ++i)
            neighbor.put(i, new LinkedList<Integer>());

        for (int[] edge : edges) {
            neighbor.get(edge[0]).add(edge[1]);
            neighbor.get(edge[1]).add(edge[0]);
            number[edge[0]] ++;
            number[edge[1]] ++;
        }

        List<Integer> leaves = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i)
            if (number[i] == 1)
                leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new LinkedList<Integer>();
            for (int i : leaves) {
                for (int j : neighbor.get(i)) {
                    if(-- number[j] == 1)
                        newLeaves.add(j);
                }
            }

            leaves = newLeaves;
        }
        return leaves;
    }
}
