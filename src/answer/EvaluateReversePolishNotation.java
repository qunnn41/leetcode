package answer;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	/**
	 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
	 */
	public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        int result = 0;
        int num1, num2;
        for (String str : tokens) {
            if (str.equals("+")) {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                stack.push((num1 + num2) + "");
            } else if (str.equals("-")) {
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                stack.push((num1 - num2) + "");
            } else if (str.equals("*")) {
                num1 = Integer.parseInt(stack.pop());
                num2 = Integer.parseInt(stack.pop());
                stack.push((num1 * num2) + "");
            } else if (str.equals("/")) {
                num2 = Integer.parseInt(stack.pop());
                num1 = Integer.parseInt(stack.pop());
                stack.push((num1 / num2) + "");
            } else {
                stack.push(str);
            }
        }
        
        result = Integer.parseInt(stack.pop());
        return result;
    }
}
