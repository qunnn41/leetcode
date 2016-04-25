package answer;

import java.util.HashMap;
import java.util.Map;
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

    //based on bucket sort
    private long getID(long i, long w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            if (d.containsKey(m))
                return true;
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            d.put(m, (long)nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }
}
