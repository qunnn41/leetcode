package answer;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
	/**
	 * https://leetcode.com/problems/summary-ranges/
	 */
	public List<String> summaryRanges(int[] nums) {
		if (nums.length == 0)
            return new LinkedList<String>();
		
		LinkedList<String> result = new LinkedList<String>();
        int startIndex = 0;
        
        int[] newnum = new int[nums.length + 1];
        
        
        for (int i = 0; i < nums.length; ++i)
        	newnum[i] = nums[i];
        newnum[nums.length] = newnum[nums.length - 1];
        
        for (int i = 1; i < newnum.length; ++i) {
        	if (i - startIndex != newnum[i] - newnum[startIndex]) {
        		//find a new range
        		int end = i - 1;
        		if (end == startIndex) {
        			//length = 1
        			result.add(newnum[startIndex] + "");
        		} else {
        			result.add(newnum[startIndex] + "->" + newnum[end]);
        		}
        		
        		startIndex = i;
        	}
        }
        
        return result;
    }
}
