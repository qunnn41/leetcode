package answer;

public class MaximumProductSubarray {
	/**
	 * https://leetcode.com/problems/maximum-product-subarray/
	 */
	public int maxProduct(int[] A) {
        int max = A[0];
        int min = A[0];
        int result = A[0];
        for (int i = 1; i < A.length; i ++) {
            int temp = A[i];
            int tmax = Math.max(temp * max, Math.max(temp * min, temp));
            int tmin = Math.min(temp * max, Math.min(temp * min, temp));
            if (tmax > result) {
                result = tmax;
            }
            max = tmax;
            min = tmin;
        }
        
        return result;
    }
}
