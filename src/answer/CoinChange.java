package answer;

public class CoinChange {
    /**
     * https://leetcode.com/problems/coin-change/
     */
    public int coinChange(int[] coins, int amount) {
        int[] array = new int[amount + 1];
        for (int i = 0; i < array.length; ++i) {
            for (int c : coins) {
                if (i + c <= amount && (i == 0 || array[i] > 0)) {
                    array[i + c] = array[i + c] == 0 ? array[i] + 1 : Math.min(array[i + c], array[i] + 1);
                }
            }
        }

        return array[amount] == 0 ? -1 : array[amount];
    }
}
