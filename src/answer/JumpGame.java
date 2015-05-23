package answer;

public class JumpGame {
	/**
	 * https://leetcode.com/problems/jump-game/
	 */
	public boolean canJump(int[] nums) {
		int result = nums.length - 1;
		for (int i = result - 1; i > -1; --i)
			if (nums[i] + i >= result)
				result = i;
		return result == 0;
    }
}
