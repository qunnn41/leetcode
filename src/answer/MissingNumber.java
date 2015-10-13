package answer;

public class MissingNumber {
	/**
	 * https://leetcode.com/problems/missing-number/
	 */
	public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
        	result ^= i;
        	result ^= nums[i];
        }
        
        return result ^= nums.length;
    }
}
