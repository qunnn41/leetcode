package answer;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
	/**
	 * https://leetcode.com/problems/kth-largest-element-in-an-array/
	 */
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((Collection<? extends Integer>) Collections.reverseOrder());
        for (int n : nums) {
        	queue.add(n);
        }
        while (k -- > 1) {
        	queue.poll();
        }
        
        return queue.peek();
	}
}