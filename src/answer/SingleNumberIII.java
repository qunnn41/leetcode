package answer;

import java.util.HashSet;

public class SingleNumberIII {
	/**
	 * https://leetcode.com/problems/single-number-iii/
	 */
	private HashSet<Integer> set = new HashSet<Integer>();
	public int[] singleNumber(int[] nums) {
        for (int n : nums) {
        	if (set.contains(n)) {
        		set.remove(n);
        	} else {
        		set.add(n);
        	}
        }
        
        int[] result = new int[2];
        int i = 0;
        for (int n : set) {
        	result[i ++] = n;
        }
        return result;
    }
}
