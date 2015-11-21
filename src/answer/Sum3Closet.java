package answer;

import java.util.Arrays;

public class Sum3Closet {
	/**
	 * https://leetcode.com/problems/3sum-closest/
	 */
	public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
        	int result = 0;
        	for (int n : nums)
        		result += n;
        	return result;
        }
        
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
        	int start = i + 1, end = nums.length - 1;
        	while (start < end) {
        		int sum = nums[i] + nums[start] + nums[end];
        		if (sum > target) {
        			end --;
        		} else {
        			start ++;
        		}
        		
        		if (Math.abs(target - sum) < Math.abs(result - target)) {
        			result = sum;
        		}
        	}
        }
        
        return result;
    }
}
