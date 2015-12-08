package answer;

import java.util.Stack;

public class BasicCalculator {
	/**
	 * https://leetcode.com/problems/basic-calculator/
	 */
	public int calculate(String s) {
        char[] ch = s.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        int sign = 1;
        int number = 0, result = 0;
        for (int i = 0; i < ch.length; ++i) {
        	char c = ch[i];
        	if (Character.isDigit(c)) {
        		number = 10 * number + (c - '0');
        	} else if (c == '+') {
        		result += sign * number;
        		sign = 1;
        		number = 0;
        	} else if (c == '-') {
        		result += sign * number;
        		sign = -1;
        		number = 0;
        	} else if (c == '(') {
        		stack.push(result);
        		stack.push(sign);
        		result = 0;
        		sign = 1;
        	} else if (c == ')') {
        		result += sign * number;
        		number = 0;
        		result *= stack.pop();
        		result += stack.pop();
        	}
        }
        
        if (number != 0) result += sign * number;
        return result;
    }
}
