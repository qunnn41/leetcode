package answer;

import java.util.Arrays;

public class SingleNumberII {
	/**
	 * https://leetcode.com/problems/single-number-ii/
	 */
	public int singleNumber(int[] A) {
        if (A.length == 1)
            return A[0];
        Arrays.sort(A);
        if (A[0] != A[1])
            return A[0];
        for (int i = 0; i + 2 < A.length; i += 3) {
            if (A[i] == A[i + 2]) {
                continue;
            } else {
                return A[i];
            }//end if
        }//end for
        return A[A.length - 1];
    }

    public int singleNumber2(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }
}
