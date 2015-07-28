package answer;

public class FirstMissingPositive {
	/**
	 * https://leetcode.com/problems/first-missing-positive/
	 */
	public int firstMissingPositive(int[] nums) {
		int i = 0, p = nums.length;
		while (i < p) {
			int n = nums[i];
			if (n == i + 1)
				++i;
			else if (n <= 0 || n > p || n == nums[n - 1])
				//out of range or duplicate
				nums[i] = nums[--p];
			else {
				//swap nums[i] and nums[n - 1]
				nums[i] = nums[n - 1];
				nums[n - 1] = n;
			}
		}
		return p + 1;
    }
}