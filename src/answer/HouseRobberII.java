package answer;

public class HouseRobberII {
	/**
	 * https://leetcode.com/problems/house-robber-ii/
	 */
	public int rob(int[] nums) {
        if (nums.length < 2)
			return rob_help(nums);
        int[] front = new int[nums.length - 1];
        int[] tail = new int[nums.length - 1];
        for (int i = 0; i < front.length; ++i)
        	front[i] = nums[i];
        for (int i = 0; i < tail.length; ++i)
        	tail[i] = nums[i + 1];
        return Math.max(rob_help(front), rob_help(tail));
    }
	
	private int rob_help(int[] nums) {
		int pre = 0, cur = 0;
		for (int i = 0; i < nums.length; ++i) {
			int temp = Math.max(pre + nums[i], cur);
			pre = cur;
			cur = temp;
		}
		return cur;
	}
}
