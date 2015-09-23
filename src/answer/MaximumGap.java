package answer;

import java.util.Arrays;

public class MaximumGap {
	/**
	 * https://leetcode.com/problems/maximum-gap/
	 */
	public int maximumGap(int[] nums) {
		if (nums.length < 2)
			return 0;
		int max = nums[0];
		int min = nums[0];
		for (int n : nums) {
			max = Math.max(max, n);
			min = Math.min(min, n);
		}
		
		int gap = (int) Math.ceil((double)(max - min) / (nums.length - 1));
		int[] bucketMin = new int[nums.length - 1];
		int[] bucketMax = new int[nums.length - 1];
		Arrays.fill(bucketMin, Integer.MIN_VALUE);
		Arrays.fill(bucketMax, Integer.MAX_VALUE);
		
		for (int i : nums) {
			if (i == min || i == max) {
				continue;
			}
			
			int index = (i - min) * gap;
			bucketMin[index] = Math.min(i, bucketMin[index]);
			bucketMax[index] = Math.max(i, bucketMax[index]);
		}
		
		int maxGap = Integer.MIN_VALUE;
		int previous = min;
		for (int i = 0; i < nums.length - 1; ++i) {
			if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) {
				//empty
				continue;
			}
			
			maxGap = Math.max(maxGap, bucketMin[i] - previous);
			previous = bucketMax[i];
		}
		
		maxGap = Math.max(maxGap, max - previous);
		return maxGap;
	}
}
