package answer;

public class FactorialTrailingZeroes {
	/**
	 * https://leetcode.com/problems/factorial-trailing-zeroes/
	 */
	public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
