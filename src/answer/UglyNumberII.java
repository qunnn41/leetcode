package answer;

public class UglyNumberII {
	/**
	 * https://leetcode.com/problems/ugly-number-ii/
	 */
	
	public int nthUglyNumber(int n) {
        int i = 0, j = 0, k = 0;
        int[] nums = new int[n];
        nums[0] = 1;
        int a = 0;
        while (a < nums.length - 1) {
        	int index = Math.min(nums[i] * 2, Math.min(nums[j] * 3, nums[k] * 5));
        	a++;
        	nums[a] = index;
        	if (index == nums[i] * 2)
        		i ++;
        	if (index == nums[j] * 3)
        		j ++;
        	if (index == nums[k] * 5)
        		k ++;
        }
        
        return nums[n - 1];
    }
}
