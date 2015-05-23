package answer;

public class BestTimeToSellStockIV {
	/**
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
	 */
	public int maxProfit(int k, int[] prices) {
        if (prices.length < 2)
            return 0;
        
        if (k > prices.length / 2)
            return gap(prices);
        int[][] f = new int[k + 1][prices.length];
        for (int kk = 1; kk <= k; kk ++) {
            int tempMax = f[kk - 1][0] - prices[0];
            for (int ii = 1; ii < prices.length; ii ++) {
                f[kk][ii] = Math.max(f[kk][ii - 1], prices[ii] + tempMax);
                tempMax = Math.max(tempMax, f[kk - 1][ii - 1] - prices[ii]);
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
