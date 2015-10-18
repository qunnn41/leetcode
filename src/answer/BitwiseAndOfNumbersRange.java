package answer;

public class BitwiseAndOfNumbersRange {
	/**
	 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
	 */
	public int rangeBitwiseAnd(int m, int n) {
        while (m < n)
            n &= n - 1;
        return n;
    }
}
