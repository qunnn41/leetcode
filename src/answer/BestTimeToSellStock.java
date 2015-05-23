package answer;

public class BestTimeToSellStock {
	/**
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	 */
	public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int max = 0;
        int sofarmin = prices[0];
        for (int i = 1; i < prices.length; i ++)
            if (prices[i] > sofarmin) {
                max = Math.max(max, prices[i] - sofarmin);
            } else {
                sofarmin = prices[i];
            }
        return max;
    }
}
