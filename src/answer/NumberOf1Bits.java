package answer;

public class NumberOf1Bits {
	/**
	 * https://leetcode.com/problems/number-of-1-bits/
	 */
	public int hammingWeight(int n) {
		int index = 1;
		int result = 0;
		while (index != 0) {
			result += (index & n) == 0 ? 0 : 1;
			index <<= 1;
		}
		return result;

		/**
		 * int count = 0;
		 * while (n != 0) {
		 * count ++;
		 * n = (n - 1) & n;
		 * }
		 * return count;
		 */
    }
}
