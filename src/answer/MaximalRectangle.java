package answer;

import java.util.Stack;

public class MaximalRectangle {
	/**
	 * https://leetcode.com/problems/maximal-rectangle/
	 */
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		
		int column = matrix[0].length;
		int row = matrix.length;
		int[] h = new int[column + 1];
		int max = 0;
		
		for (int r = 0; r < row; ++r) {
			Stack<Integer> s = new Stack<Integer>();
			for (int i = 0; i < h.length; ++i) {
				if (i < column) {
					if (matrix[r][i] == '1')
						h[i] ++;
					else
						h[i] = 0;
				}
				
				if (s.isEmpty() || h[s.peek()] <= h[i])
					s.push(i);
				else {
					while (!s.isEmpty() && h[i] < h[s.peek()]) {
						int area = h[s.pop()] * (s.isEmpty() ? i : (i - s.peek() - 1));
						max = Math.max(max, area);
					}
					s.push(i);
				}
			}
		}
		
		return max;
	}
}
