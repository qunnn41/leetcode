package answer;

public class SetMatrixZeroes {
	/**
	 * https://leetcode.com/problems/set-matrix-zeroes/
	 */
	public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        //flag1->[0][0]
        //flag2->[0][i]
        //flag3->[j][0]
        boolean flag1 = matrix[0][0] == 0 ? true : false;
        boolean flag2 = flag1, flag3 = flag1;
        if ( !flag2) {
            for (int i = 1; i < m; ++i)
                if (matrix[i][0] == 0) {
                    flag2 = true;
                    break;
                }
        }//end if
        
        if ( !flag3) {
            for (int i = 1; i < n; ++i)
                if (matrix[0][i] == 0) {
                    flag3 = true;
                    break;
                }
        }//end if
        
        
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < m; i ++)
            for (int j = 1; j < n; j ++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
        
        if (flag1) {
            for (int j = 0; j < n; ++j)
                matrix[0][j] = 0;
            for (int i = 0; i < m; ++i)
                matrix[i][0] = 0;
            return;
        }
        
        if (flag2) {
            for (int i = 0; i < m; ++i)
                matrix[i][0] = 0;
        }
        
        if (flag3) {
            for (int j = 0; j < n; ++j)
                matrix[0][j] = 0;
        }
    }
}
