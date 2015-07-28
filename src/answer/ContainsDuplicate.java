package answer;

import java.util.HashSet;

public class ContainsDuplicate {
	/**
	 * https://leetcode.com/problems/contains-duplicate/
	 */
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int n : nums) {
			if (set.contains(n))
				return true;
			set.add(n);
		}
		return false;
    }
}
