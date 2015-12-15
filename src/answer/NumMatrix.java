package answer;

public class NumMatrix {
    /**
     * https://leetcode.com/problems/range-sum-query-2d-immutable/
     */
    private int[][] sum;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ;
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m][n];

        sum[0][0] = matrix[0][0];
        for (int i = 1; i < m; ++i) {
            sum[i][0] = matrix[i][0] + sum[i - 1][0];
        }

        for (int i = 1; i < n; ++i) {
            sum[0][i] = matrix[0][i] + sum[0][i - 1];
        }

        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n; ++j)
                sum[i][j] = matrix[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum == null) {
            return 0;
        }
        if (row1 == 0 && col1 == 0)
            return sum[row2][col2];
        if (row1 == 0)
            return sum[row2][col2] - sum[row2][col1 - 1];
        if (col1 == 0)
            return sum[row2][col2] - sum[row1 - 1][col2];
        return sum[row2][col2] + sum[row1 - 1][col1 - 1] - sum[row1 - 1][col2] - sum[row2][col1 - 1];
    }
}
