package answer;

public class LongestIncreasingPathInMatrix {
    /**
     * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
     */
    int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] state = new int[m][n];
        int result = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                result = Math.max(result, dfs(state, matrix, i, j));
            }
        }

        return result;
    }

    private int dfs(int[][] state, int[][] matrix, int x, int y) {
        if (state[x][y] > 0)
            return state[x][y];
        int max = 0;
        int [][]dis = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int i = 0; i < dis.length; ++i) {
            int xx = x + dis[i][0];
            int yy = y + dis[i][1];
            if (xx > -1 && xx < m && yy > -1 && yy < n && matrix[xx][yy] > matrix[x][y]) {
                max = Math.max(max, dfs(state, matrix, xx, yy));
            }
        }

        state[x][y] = 1 + max;
        return state[x][y];
    }
}
