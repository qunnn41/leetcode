package answer;

public class SingleNumber {
	/**
	 * https://leetcode.com/problems/single-number/
	 */
	public int singleNumber(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i ++)
            result ^= A[i];
        return result;
    }
}
