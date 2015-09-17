package answer;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementsII {
	/**
	 * https://leetcode.com/problems/majority-element-ii/
	 */
	public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return result;
        int count1 = 0, count2 = 0, m1 = 0, m2 = 0;
        for (int n : nums) {
        	if (n == m1) {
        		count1 ++;
        	} else if (n == m2) {
        		count2 ++;
        	} else if (count1 == 0) {
        		m1 = n;
        		count1 = 1;
        	} else if (count2 == 0) {
        		m2 = n;
        		count2 = 1;
        	} else {
        		count1 --;
        		count2 --;
        	}
        }
        
        count1 = 0;
        count2 = 0;
        
        for (int n : nums)
        	if (n == m1) count1 ++;
        	else if (n == m2) count2 ++;
        
        if (count1 > nums.length / 3)
        	result.add(m1);
        if (count2 > nums.length / 3)
        	result.add(m2);
        
        return result;
    }
}
