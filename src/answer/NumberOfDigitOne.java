package answer;

public class NumberOfDigitOne {
	/**
	 * https://leetcode.com/problems/number-of-digit-one/
	 */
	public int countDigitOne(int n) {
		int ones = 0;
	    for (long m = 1; m <= n; m *= 10)
	        ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
	    return ones;
    }
    public int countDigitOne2(int n) {
        int count = 0, factor = 1;
        int lowerNum = 0, currNum = 0, higherNum = 0;
        while (n / factor != 0) {
            lowerNum = n - (n / factor) * factor;
            currNum = (n / factor) % 10;
            higherNum = n / (factor * 10);

            if (currNum == 0) {
                count += higherNum * factor;
            } else if (currNum == 1) {
                count += higherNum * factor + lowerNum + 1;
            } else {
                count += higherNum * factor + factor;
            }

            factor *= 10;
        }
        return count;
    }
}
