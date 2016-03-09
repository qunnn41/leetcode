package answer;

public class SingleNumberIII {
	/**
	 * https://leetcode.com/problems/single-number-iii/
	 */
	public int[] singleNumber(int[] nums) {
		int r = 0;
		for (int n : nums)
			r ^= n;
		int firstIndexOf1 = FindFirstBitIs1(r);
		int num1 = 0, num2 = 0;
		for (int n : nums) {
			if (IsBit1(n, firstIndexOf1)) {
				num1 ^= n;
			} else {
				num2 ^= n;
			}
		}

		return new int[]{num1, num2};
	}

	private boolean IsBit1(int num, int index) {
		num = num >> index;
		return (num & 1) == 1;
	}

	private int FindFirstBitIs1(int num) {
		int index = 0;
		while ((num & 1) == 0 && index < 32) {
			num = num >> 1;
			++ index;
		}
		return index;
	}
}
