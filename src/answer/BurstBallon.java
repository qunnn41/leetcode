package answer;

public class BurstBallon {
    /**
     * https://leetcode.com/problems/burst-balloons/
     */
    public int maxCoins(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] Num = new int[nums.length + 2];
        int n = 1;
        for (int x : nums)
            Num[n ++] = x;
        Num[0] = Num[n ++] = 1;

        int[][]coin = new int[n][n];
        for (int k = 2; k < n; ++k) {
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i) {
                    coin[left][right] = Math.max(coin[left][right],
                            coin[left][i] + coin[i][right] + Num[left] * Num[i] * Num[right]);
                }
            }
        }

        return coin[0][n - 1];
    }
}
