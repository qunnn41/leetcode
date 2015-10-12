package answer;

public class MoveZeroes {
	/**
	 * https://leetcode.com/problems/move-zeroes/
	 */
	public void moveZeroes(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] != 0) {
				nums[index ++] = nums[i];
			}
		}
		
		while (index < nums.length) {
			nums[index ++] = 0;
		}
    }
}
