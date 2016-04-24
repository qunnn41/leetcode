package answer;

public class DistinctSubsequences {
	/**
	 * https://leetcode.com/problems/distinct-subsequences/
	 */
	public int numDistinct(String S, String T) {
        int sl = S.length();
        int tl = T.length();

        int[] dp = new int[tl + 1];
        dp[0] = 1;

        for(int s = 1; s <= sl; s++)
            for(int t = tl; t >= 1; t--){
                if(S.charAt(s-1) == T.charAt(t-1))
                    dp[t] += dp[t - 1];
            }

        return dp[tl];
    }

    public int numDistinct2(String S, String T) {
        int[][] dp = new int[T.length() + 1][S.length() + 1];
        for (int i = 0; i <= S.length(); ++i)
            dp[0][i] = 1;

        for (int i = 1; i <= T.length(); ++i) {
            for (int j = 1; j <= S.length(); ++j) {
                dp[i][j] = S.charAt(j - 1) == T.charAt(i - 1) ? dp[i - 1][j - 1] + dp[i][j - 1] : dp[i][j - 1];
            }
        }
        return dp[T.length()][S.length()];
    }
}
