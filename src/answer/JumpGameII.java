package answer;

public class JumpGameII {
	/**
	 * https://leetcode.com/problems/jump-game-ii/
	 */
	public int jump(int[] nums) {
		int step = 0, i = 0, nextMax = 0;
		int curMax = 0;
		while (curMax > i - 1) {
			step ++;
			while (i <= curMax) {
				nextMax = Math.max(nextMax, nums[i] + i);
				if (nextMax >= nums.length - 1)
					return step;
				i ++;
			}
			curMax = nextMax;
		}
		return -1;
    }
	
	public int jump2(int[] nums) {
		//minimum step reaching a
		int count = 0;
		int max = 0;
		//longest distance in current step
		int a = 0;
		for (int i = 0; i < nums.length - 1; ++i) {
			max = Math.max(max, nums[i] + i);
			if (i == a) {
				count ++;
				a = max;
			}
		}
		
		return count;
	}
}
