package answer;

public class AddDigits {
	/**
	 * https://leetcode.com/problems/add-digits/
	 */
	public int addDigits(int num) {
        while (num > 9) {
        	int temp = 0;
        	while (num > 9) {
        		temp += (num % 10);
        		num /= 10;
        	}
        	
        	temp += num;
        	num = temp;
        }
        
        return num;
    }
}
