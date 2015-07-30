package answer;

public class Pow {
	/**
	 * https://leetcode.com/problems/powx-n/
	 */
	public double myPow(double x, int n) {
		if (n == 0)
			return 1;
		double t = myPow(x, n / 2);
		if (n % 2 == 0)
			return t * t;
		else {
			if (n > 0)
				return x * t * t;
			return (t * t) / x;
		}
    }
}
