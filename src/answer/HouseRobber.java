package answer;

public class HouseRobber {
	/**
	 * https://leetcode.com/problems/house-robber/
	 */
	public int rob(int[] nums) {
		//pre->do not rob[i - 1]
		//cur->do rob[i - 1]
		int pre = 0, cur = 0;
		for (int i = 0; i < nums.length; ++i) {
			int temp = Math.max(pre + nums[i], cur);
			pre = cur;
			cur = temp;
		}
		return cur;
	}
}
