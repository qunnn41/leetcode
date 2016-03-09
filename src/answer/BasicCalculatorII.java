package answer;

import java.util.Stack;

public class BasicCalculatorII {
	/**
	 * https://leetcode.com/problems/basic-calculator-ii/
	 */
	public int calculate(String s) {
		if (s == null || s.length() == 0) 
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		char[] array = s.toCharArray();
		char sign = '+';
		for (int i = 0; i < array.length; ++i) {
			char ch = array[i];
			if (Character.isDigit(ch)) {
				num = (num * 10 + (ch - '0'));
			}
			
			if (i == array.length - 1 || (!Character.isDigit(ch) && ch != ' ')) {
				if (sign == '+') {
					stack.push(num);
				} else if (sign == '-') {
					stack.push(-num);
				} else if (sign == '*') {
					stack.push(stack.pop() * num);
				} else if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				
				
				sign = ch;
				num = 0;
			}
		}
		
		int result = 0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;
	}
}