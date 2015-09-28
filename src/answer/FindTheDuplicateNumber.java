package answer;

public class FindTheDuplicateNumber {
	/**
	 * https://leetcode.com/problems/find-the-duplicate-number/
	 */
	public int findDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
        	int mid = (high + low) / 2;
        	int count = 0;
        	for (int n : nums)
        		if (n <= mid)
        			count ++;
        	if (count <= mid)
        		low = mid + 1;
        	else
        		high = mid;
        }
        
        return low;
    }
}
