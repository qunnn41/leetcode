package answer;

public class BestTimetoBuyandSellStockwithCooldown {
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
     */
    public int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            //buy[i] = max(sell[i - 2] - price[i], buy[i - 1])
            buy = Math.max(prev_sell - price, prev_buy);

            prev_sell = sell;
            //sell[i] = max(buy[i - 1] + price[i], sell[i - 1])
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}
