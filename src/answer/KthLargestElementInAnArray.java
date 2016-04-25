package answer;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
	/**
	 * https://leetcode.com/problems/kth-largest-element-in-an-array/
	 */
	public int findKthLargest(int[] nums, int k) {
		return nums[quickSelect(nums, 0, nums.length - 1, nums.length - k + 1)];
	}
	private int quickSelect(int[] nums, int low, int high, int k) {
		int i = low, j = high, pivot = nums[high];
		while (i < j) {
			if (nums[i] > pivot) {
				--j;
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
			} else {
				++i;
			}
		}

		int temp = nums[i];
		nums[i] = nums[high];
		nums[high] = temp;

		int m = i - low + 1;
		if (m == k)
			return i;
		if (m > k)
			return quickSelect(nums, low, i - 1, k);
		return quickSelect(nums, i + 1, high, k - m);
	}


}