package answer;

public class BestTimeToSellStockIII {
	/**
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
	 */
	public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int k = 2;
        int maxpro = 0;
        
        int[][] f = new int[k + 1][prices.length];
        for (int kk = 1; kk <= k; kk ++) {
            int tempMax = f[kk - 1][0] - prices[0];
            for (int ii = 1; ii < prices.length; ii ++) {
                f[kk][ii] = Math.max(f[kk][ii - 1], prices[ii] + tempMax);
                tempMax = Math.max(tempMax, f[kk - 1][ii] - prices[ii]);
                maxpro = Math.max(maxpro, f[kk][ii]);
            }
        }

        //return f[k][prices.length-1];
        return maxpro;
    }
}
