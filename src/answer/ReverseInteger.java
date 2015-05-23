package answer;

public class ReverseInteger {
	/**
	 * https://leetcode.com/problems/reverse-integer/
	 */
	public int reverse(int x) {
        int result = 0;
        int temp = x;
        while (temp != 0) {
            int n = temp % 10;
            temp = temp / 10;
            int nn = result * 10 + n;
            //check overflow
            if ((nn - n) / 10 != result)
                return 0;
            result = nn;
        }//end while
        return result;
    }
}
