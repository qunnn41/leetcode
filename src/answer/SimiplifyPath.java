package answer;

import java.util.Stack;

public class SimiplifyPath {
	/**
	 * https://leetcode.com/problems/simplify-path/
	 */
	public String simplifyPath(String path) {
        String[] str = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String s : str) {
        	if (s.equals("") || s.equals(".")) {
        	} else if (s.equals("..")) {
        		if (!stack.isEmpty()) 
        			stack.pop();
        	} else {
        		stack.push(s);
        	}
        }
        
        String result = "";
        while (!stack.isEmpty()) {
        	result = "/" + stack.pop() + result;
        }
        return result == "" ? "/" : result;
    }
}
