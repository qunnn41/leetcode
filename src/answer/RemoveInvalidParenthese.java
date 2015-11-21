package answer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveInvalidParenthese {
	/**
	 * https://leetcode.com/problems/remove-invalid-parentheses/
	 */
	public List<String> removeInvalidParentheses(String s) {
        List<String> result = new LinkedList<String>();
        if (s == null)
        	return result;
        HashSet<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        
        queue.add(s);
        visited.add(s);
        boolean flag = false;
        while (!queue.isEmpty()) {
        	String str = queue.poll();
        	if (isValid(str)) {
        		result.add(str);
        		flag = true;
        	}
        	
        	if (flag)
        		continue;
        	
        	for (int i = 0; i < str.length(); ++i) {
        		if (str.charAt(i) != '(' && str.charAt(i) != ')')
        			continue;
        		String t = str.substring(0, i) + str.substring(i + 1);
        		if (!visited.contains(t)) {
        			queue.add(t);
        			visited.add(t);
        		}
        	}
        }
        if (result.size() == 0)
            result.add("");
            
        return result;
    }
	
	private boolean isValid(String s) {
		int count = 0;
		char[] array = s.toCharArray();
		for (char ch : array) {
			if (ch == '(')
				count ++;
			if (ch == ')') {
				count --;
				if (count < 0) return false;
			}
		}
		
		return count == 0;
	}
}
