package answer;

import java.util.Stack;

public class LongestValidParentheses {
	/**
	 * https://leetcode.com/problems/longest-valid-parentheses/
	 */
	public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int maxL = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; ++i) {
        	int t = stack.peek();
        	if (t != -1 && array[i] == ')' && array[t] == '(') {
        		stack.pop();
        		maxL = Math.max(maxL, i - stack.peek());
        	} else {
        		stack.push(i);
            }
        }
        
        return maxL;
    }
}
