package answer;

import java.util.LinkedList;
import java.util.List;

public class DifferentWaysToAddParenthese {
	/**
	 * https://leetcode.com/problems/different-ways-to-add-parentheses/
	 */
	public List<Integer> diffWaysToCompute(String input) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        
        char[] array = input.toCharArray();
        for (int i = 0; i < array.length; ++i) {
        	if (array[i] == '+' || array[i] == '-' || array[i] == '*') {
        		List<Integer> left = diffWaysToCompute(input.substring(0, i));
        		List<Integer> right = diffWaysToCompute(input.substring(i + 1));
        		
        		for (int l : left) {
        			for (int r : right) {
        				if (array[i] == '+') {
        					result.add(l + r);
        				} else if (array[i] == '-') {
        					result.add(l - r);
        				} else {
        					result.add(l * r);
        				}
        			}
        		}
        	}
        }
        
        if (result.size() == 0) {
        	result.add(Integer.parseInt(input));
        }
        
        return result;
    }
}
