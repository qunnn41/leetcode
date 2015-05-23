package answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {
	/**
	 * https://leetcode.com/problems/4sum/
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < nums.length - 3; ++i) {
        	if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
        		for (int j = i + 1; j < nums.length - 2; ++j) {
        			if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
        				int l = j + 1, h = nums.length - 1, sum = target - nums[i] - nums[j];
        				while (l < h) {
        					if (nums[l] + nums[h] == sum) {
        						result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[h]));
        						while (l < h && nums[l] == nums[l + 1]) ++l;
        						while (l < h && nums[h] == nums[h - 1]) --h;
        						++l; --h;
        					} else if (nums[l] + nums[h] < sum) {
        						++l;
        					} else {
        						--h;
        					}
        				}
        			}
        		}//end for j
        	}
        }//end for i
        
        return result;
    }
}
