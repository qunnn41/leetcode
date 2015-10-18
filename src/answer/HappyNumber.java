package answer;

import java.util.HashSet;

public class HappyNumber {
	/**
	 * https://leetcode.com/problems/happy-number/
	 */
	private HashSet<Integer> number = new HashSet<Integer>();
	public boolean isHappy(int n) {
		if (n == 1)
			return true;
        int current = 0;
        while (n > 0) {
        	int m = n % 10;
        	current += m * m;
        	n /= 10;
        }
        
        if (number.contains(current))
        	return false;
        number.add(current);
        return isHappy(current);
    }
}