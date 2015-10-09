package answer;

import java.util.HashMap;

public class TwoSum {
	/**
	 * https://leetcode.com/problems/two-sum/
	 */
	public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        map.put(target - nums[0], 0);
        for (int i = 1; i < nums.length; ++i) {
        	if (map.keySet().contains(nums[i])) {
        		result[0] = map.get(nums[i]) + 1;
        		result[1] = i + 1;
        		break;
        	} else {
        		map.put(target - nums[i], i);
        	}
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		new TwoSum().twoSum(new int[] {2,7,11,15}, 9);
	}
}
