package answer;

import java.util.Stack;

public class MinStack {
	/**
	 * https://leetcode.com/problems/min-stack/
	 */
	private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();
    
    public void push(int x) {
        stack.push(x);
        if (min.size() != 0) {
            int temp = min.peek();
            if (x <= temp)
                min.push(x);
        } else {
            min.push(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        if (min.size() != 0) {
            if (x == min.peek())
                min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
