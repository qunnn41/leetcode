package answer;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
	/**
	 * https://leetcode.com/problems/sliding-window-maximum/
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0)
            return new int[0];
        
		int[] result = new int[nums.length - k + 1];
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		for (int i = 0; i < k; ++i) {
			queue.add(nums[i]);
		}
		
		result[0] = queue.peek();
		for (int i = k; i < nums.length; ++i) {
			queue.remove(nums[i - k]);
			queue.add(nums[i]);
			result[i - k + 1] = queue.peek();
		}
		
		return result;
    }
}
