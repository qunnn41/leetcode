package answer;

public class NumArray {
    /**
     * https://leetcode.com/problems/range-sum-query-immutable/
     */
    private int[] sum;
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
    	sum = new int[nums.length];
    	sum[0] = nums[0];
    	for (int i = 1; i < sum.length; ++i)
    		sum[i] = sum[i - 1] + nums[i];
    }

    public int sumRange(int i, int j) {
        if (sum == null || sum.length == 0)
            return 0;
    	if (i == 0)
    		return sum[j];
    	return sum[j] - sum[i - 1];
    }
}
