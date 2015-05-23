package answer;

public class MaximumSubarray {
	/**
	 * https://leetcode.com/problems/maximum-subarray/
	 */
	public int maxSubArray(int[] A) {
        if (A == null || A.length == 0)
            return 0;
            
        int max = A[0];
        int temp = max;
        for (int i = 1; i < A.length; ++i) {
            if (temp < 0)
                temp = A[i];
            else
                temp += A[i];
            max = Math.max(max, temp);
        }
        return max;
    }
}
