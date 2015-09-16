package answer;

public class StringToInteger {
	/**
	 * https://leetcode.com/problems/string-to-integer-atoi/
	 */
	public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty())
        	return 0;
        int sign = 1;
        int i = 0;
        char[] array = str.toCharArray();
        if (array[i] == '-' || array[i] == '+') {
        	sign = (array[i] == '-') ? -1 : 1;
        	if (array.length < 2 || !Character.isDigit(array[1])) {
        		return 0;
        	}
        	
        	++i;
        }
        
        int result = 0;
        while (i < array.length) {
        	if (Character.isDigit(array[i])) {
        		int d = array[i] - '0';
        		if (result > (Integer.MAX_VALUE - d) / 10) {
        			return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        		}
        		
        		result = result * 10 + d;
        	} else
        		break;
        	
        	++i;
        }
        return sign * result;
    }
}
