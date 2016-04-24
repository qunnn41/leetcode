package answer;

public class DivideTwoInteger {
	/**
	 * https://leetcode.com/problems/divide-two-integers/
	 */
    public int divide(int dividend, int divisor) {
        if (divisor == 1)
            return dividend;
        long dividend_l = (long)dividend;
        long divisor_l = (long)divisor;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        dividend_l = Math.abs(dividend_l);
        divisor_l = Math.abs(divisor_l);
        int result = 0;
        while (dividend_l >= divisor_l) {
            long temp = divisor_l, multiple = 1;
            while (dividend_l > (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            dividend_l -= temp;
            result += multiple;
        }
        //overflow
        if (result < 0)
            return Integer.MAX_VALUE;
        return sign == 1 ? result : -result;
    }
}
