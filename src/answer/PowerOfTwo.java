package answer;

public class PowerOfTwo {
	/**
	 * https://leetcode.com/problems/power-of-two/
	 */
	public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        if (n < 3)
        	return true;
        if (n % 2 != 0)
        	return false;
        return isPowerOfTwo(n / 2);
    }
	
	public static void main(String[] args) {
		System.out.println(new PowerOfTwo().isPowerOfTwo(1026));
	}
}
