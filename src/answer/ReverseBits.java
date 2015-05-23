package answer;

public class ReverseBits {
	/**
	 * https://leetcode.com/problems/reverse-bits/
	 */
	public int reverseBits(int n) {
        int m = 0;
        for (int i = 0; i < 32; i ++) {
            m = (m << 1) | (n & 1);
            n = n >> 1;
        }
        return m;
    }
}
