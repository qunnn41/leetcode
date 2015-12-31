package answer;

public class CreateMaximumNumber {
    /**
     * https://leetcode.com/problems/create-maximum-number/
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0))
                ans = candidate;
        }

        return ans;
    }

    private int[] merge(int[] num1, int[] num2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = greater(num1, i, num2, j) ? num1[i ++] : num2[j ++];
        return ans;
    }

    /**
     * num1[i] > num2[j] ? 1 : 0;
     */
    private boolean greater(int[] num1, int i, int[] num2, int j) {
        while (i < num1.length && j < num2.length && num1[i] == num2[j]) {
            i ++;
            j ++;
        }

        return j == num2.length || (i < num1.length && num1[i] > num2[j]);
    }

    private int[] maxArray(int[] num, int k) {
        int n = num.length;
        int[] ans = new int[k];
        int i = 0, j = 0;
        while (i < n) {
            while (n - i + j > k && j > 0 && ans[j - 1] < num[i])
                j --;
            if (j < k)
                ans[j ++] = num[i];
            ++i;
        }
        return ans;
    }
}
