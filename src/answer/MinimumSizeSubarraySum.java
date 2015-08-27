package answer;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumSizeSubarraySum {
	/**
	 * https://leetcode.com/problems/minimum-size-subarray-sum/
	 */
	public int minSubArrayLen(int s, int[] nums) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int n : nums) {
			sum += n;
			queue.add(n);
			if (sum >= s) {
				while (sum - queue.peek() >= s)
					sum -= queue.poll();
				min = Math.min(min, queue.size());
			}
		}
		
		return sum < s ? 0 : min;
    }
}
