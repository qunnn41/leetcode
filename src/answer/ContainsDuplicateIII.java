package answer;

import java.util.TreeSet;

public class ContainsDuplicateIII {
	/**
	 * https://leetcode.com/problems/contains-duplicate-iii/
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length < 2 || k <= 0)
			return false;
        final TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; ++i) {
        	Integer floor = set.floor(nums[i] + t);
        	Integer ceil = set.ceiling(nums[i] - t);
        	
        	if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i]))
        			return true;
        	
        	set.add(nums[i]);
        	if (i >= k) {
        		set.remove(nums[i - k]);
        	}
        }
        
        return false;
    }
}
