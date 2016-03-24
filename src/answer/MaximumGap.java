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
        //get the min and max
		for (int n : nums) {
			max = Math.max(max, n);
			min = Math.min(min, n);
		}
		
        //the minimum possible gap, ceiling of the integer division
		int gap = (int) Math.ceil((double)(max - min) / (nums.length - 1));
        //n - 2 numbers which is not equal to min and max, n - 1 bucket
        //at least one bucket is empty
		int[] bucketMin = new int[nums.length - 1];
		int[] bucketMax = new int[nums.length - 1];
		Arrays.fill(bucketMin, Integer.MAX_VALUE);
		Arrays.fill(bucketMax, Integer.MIN_VALUE);
		
        //put numbers into buckets
		for (int i : nums) {
			if (i == min || i == max) {
				continue;
			}
			
			int index = (i - min) / gap;
			bucketMin[index] = Math.min(i, bucketMin[index]);
			bucketMax[index] = Math.max(i, bucketMax[index]);
		}
		
        //scan the buckets for the max gap
		int maxGap = Integer.MIN_VALUE;
		int previous = min;
		for (int i = 0; i < nums.length - 1; ++i) {
			if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) {
				//empty
				continue;
			}
			
			maxGap = Math.max(maxGap, bucketMin[i] - previous);
            //update previous bucket value
			previous = bucketMax[i];
		}
		
		maxGap = Math.max(maxGap, max - previous);
		return maxGap;
	}
}
