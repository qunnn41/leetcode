package answer;

public class BestTimeToSellStockIV {
	/**
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
	 */

    /**
     * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
     *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
 */
	public int maxProfit(int k, int[] prices) {
        if (prices.length < 2)
            return 0;
        
        if (k > prices.length / 2)
            return gap(prices);
        int[][] f = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i ++) {
            int tempMax = f[i - 1][0] - prices[0];
            for (int j = 1; j < prices.length; j ++) {
                f[i][j] = Math.max(f[i][j - 1], prices[j] + tempMax);
                tempMax = Math.max(tempMax, f[i - 1][j - 1] - prices[j]);
            }
        }
        
        return f[k][prices.length - 1];
    }
    
    private int gap(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i ++)
            if (prices[i] > prices[i - 1])
                max += (prices[i] - prices[i - 1]);
        return max;
    }
}
