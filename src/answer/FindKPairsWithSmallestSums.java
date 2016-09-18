package answer;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
    /**
     * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
     */
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new LinkedList<>();
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int x : nums1) {
            for (int y : nums2) {
                pq.add(new Tuple(x, y, x + y));
            }
        }

        for (int i = 0; i < k; ++i) {
            if (!pq.isEmpty()) {
                Tuple tuple = pq.poll();
                result.add(new int[]{tuple.x, tuple.y});
            }
        }

        return result;
    }

    class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple tuple) {
            return this.val - tuple.val;
        }
    }
}
