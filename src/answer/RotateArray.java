package answer;

public class RotateArray {
	/**
	 * https://leetcode.com/problems/rotate-array/
	 */
	public void rotate(int[] nums, int k) {
        int temp, n = nums.length;
        if (k == 0) return;
        while (k > n) k -= n;
        k = n - k;
        for (int i = 0; i < k / 2; ++i) {
            temp = nums[i];
            nums[i] = nums[k - 1 - i];
            nums[k - 1 - i] = temp;
        }
        
        for (int i = k, j = 0; i < (n + k) / 2; ++i, ++j) {
            temp = nums[i];
            nums[i] = nums[n - 1 - j];
            nums[n - 1 - j] = temp;
        }
        
        for (int i = 0; i < n / 2; ++i) {
            temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 - i] = temp;
        }
    }
}
