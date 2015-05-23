package answer;

public class DistinctSubsequences {
	/**
	 * https://leetcode.com/problems/distinct-subsequences/
	 */
	public int numDistinct(String S, String T) {
        int sl = S.length();
        int tl = T.length();

        int[] dp = new int[tl+1];
        dp[0] = 1;

        for(int s = 1; s <= sl; s++)
            for(int t = tl; t >= 1; t--){
                if(S.charAt(s-1) == T.charAt(t-1))
                    dp[t] += dp[t-1];
            }

        return dp[tl];
    }
}
