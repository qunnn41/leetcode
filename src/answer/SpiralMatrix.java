package answer;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	/**
	 * https://leetcode.com/problems/spiral-matrix/
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0) return result;
        int n = matrix[0].length;
        
        int count = 0, index = 0;
        while (true) {
            for (int i = index; i < n - index; ++i) {
                result.add(matrix[index][i]);
                ++count;
                if (count == m * n) return result;
            }
            
            for (int i = 1 + index; i < m - index; ++i) {
                result.add(matrix[i][n - 1 - index]);
                ++count;
                if (count == m * n) return result;
            }
            
            for (int i = n - 2 - index; i > index; --i) {
                result.add(matrix[m - 1 - index][i]);
                ++count;
                if (count == m * n) return result;
            }
            
            for (int i = m - 1 - index; i > index; --i) {
                result.add(matrix[i][index]);
                ++count;
                if (count == m * n) return result;
            }
            
            ++index;
        }
    }
}
