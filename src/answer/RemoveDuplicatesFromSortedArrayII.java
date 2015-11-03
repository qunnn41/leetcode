package answer;

public class RemoveDuplicatesFromSortedArrayII {
	/**
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
	 */
	public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
        	return nums.length;
        
        int temp = nums[0];
        //false means appear once, true means appear twice
        boolean flag = false;
        int count = 0;
        
        for (int i = 1; i < nums.length; i ++) {
        	if (temp == nums[i]) {
        		if (!flag) {
        			flag = true;
        		} else {
        			count ++;
        		}
        	} else {
        		temp = nums[i];
        		flag = false;
        	}
        	
        	nums[i - count] = nums[i];
        }
        
        return nums.length - count;
    }
}
