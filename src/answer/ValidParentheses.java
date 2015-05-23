package answer;

import java.util.Stack;

public class ValidParentheses {
	/**
	 * https://leetcode.com/problems/valid-parentheses/
	 */
	public boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return false;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < s.length(); ++i) {
        	char ch = s.charAt(i);
        	if (ch == '(') {
        		stack.push(1);
        		continue;
        	}
        	
        	if (ch == '[') {
        		stack.push(2);
        		continue;
        	}
        	
        	if (ch == '{') {
        		stack.push(3);
        		continue;
        	}
        	
        	if (ch == ')') {
        		if (stack.isEmpty() || stack.pop() != 1)
        			return false;
        		continue;
        	}
        	
        	if (ch == ']') {
        		if (stack.isEmpty() || stack.pop() != 2)
        			return false;
        		continue;
        	}
        	
        	if (ch == '}') {
        		if (stack.isEmpty() || stack.pop() != 3)
        			return false;
        		continue;
        	}
        }
        
        if (stack.isEmpty())
        	return true;
        return false;
    }
}
