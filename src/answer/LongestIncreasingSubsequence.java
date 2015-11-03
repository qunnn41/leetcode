package answer;

public class LongestIncreasingSubsequence {
	/**
	 * https://leetcode.com/problems/longest-increasing-subsequence/
	 */
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < dp.length; ++i) {
        	dp[i] = 1;
        	for (int j = 0; j < i; ++j) {
        		if (nums[i] > nums[j] && dp[j] + 1 > dp[i])
        			dp[i] = dp[j] + 1;
        	}
        	max = Math.max(max, dp[i]);
        }
        return max;
    }
}
