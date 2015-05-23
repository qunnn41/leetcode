package answer;

public class SearchA2DMatrix {
	/**
	 * https://leetcode.com/problems/search-a-2d-matrix/
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
        	int med = (low + high) / 2;
        	int m_med = matrix[med / n][med % n];
        	if (m_med < target) {
        		low = med + 1;
        	} else if (m_med > target) {
        		high = med - 1;
        	} else return true;
        }
        return false;
    }
}
