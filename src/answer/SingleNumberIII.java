package answer;

public class SingleNumberIII {
	/**
	 * https://leetcode.com/problems/single-number-iii/
	 */
	public int[] singleNumber(int[] nums) {
		int r = 0;
		for (int n : nums)
			r ^= n;
		int a = 0;
		//r & -r get the lowest index which is 1
		for (int n : nums)
			if ((n & r & -r) > 0)
				a ^= n;

		return new int[]{a, a ^ r};
	}
}
