package answer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Triangle {
	/**
	 * https://leetcode.com/problems/triangle/
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		Stack<List<Integer>> result = new Stack<List<Integer>>();
		result.push(triangle.get(triangle.size() - 1));
		for (int i = triangle.size() - 2; i > -1; --i) {
			//below list
			List<Integer> list = result.peek();
			
			//current list
			List<Integer> current = triangle.get(i);
			
			//restore list
			List<Integer> temp = new LinkedList<Integer>();
			for (int j = 0; j < current.size(); ++j) {
				int min = Math.min(list.get(j), list.get(j + 1));
				temp.add(current.get(j) + min);
			}
			
			result.push(temp);
		}
		
		return result.peek().get(0);
	}
}

