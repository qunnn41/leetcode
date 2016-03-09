package answer;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem {
	/**
	 * https://leetcode.com/problems/the-skyline-problem/
	 */
	class Pair implements Comparable<Pair> {
        int index;
        int height;
        Pair(int i, int h) {
            this.index = i;
            this.height = h;
        }
    
        public int compareTo(Pair p) {
            if (this.index != p.index) 
            	return this.index - p.index;
            return this.height - p.height;
        }
    
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new LinkedList<int[]>();
        if (buildings == null || buildings.length == 0) return result;
        int len = buildings.length;
        Pair[] pairs = new Pair[2 * len];
        for (int i = 0; i < len; i++) {
            pairs[2 * i] = new Pair(buildings[i][0], -buildings[i][2]);
            pairs[2 * i + 1] = new Pair(buildings[i][1], buildings[i][2]);
        }
        Arrays.sort(pairs);
        int height = 0;
        // Priority queue in java allows duplicates
        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(len, Collections.reverseOrder());
        for (Pair p: pairs) {
            if (p.height < 0) 
            	maxPQ.add(-p.height);
            else 
            	maxPQ.remove(p.height);
            
            int newH = (maxPQ.peek() == null) ? 0 : maxPQ.peek();
            if (newH != height) {
                height = newH;
                int[] re = new int[2];
                re[0] = p.index;
                re[1] = height;
                result.add(re);
            }
        }
        return result;
    }
}
