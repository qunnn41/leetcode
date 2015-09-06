package answer;

public class UglyNumber {
	/**
	 * https://leetcode.com/problems/ugly-number/
	 */
	public boolean isUgly(int num) {
        if (num <= 0) {
        	return false;
        }
        
        if (num < 7) {
        	return true;
        }
        
        int i = num;
        
        while (num % 2 == 0) {
        	num /= 2;
        }
        
        while (num % 3 == 0) {
        	num /= 3;
        }
        
        while (num % 5 == 0) {
        	num /= 5;
        }
        
        if (i == num)
        	return false;
        
        return isUgly(num);
    }
}
