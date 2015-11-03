package answer;

public class UniquePathII {
	/**
	 * https://leetcode.com/problems/unique-paths-ii/
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] path = new int[m][n];
        path[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; ++i)
        	path[i][0] = obstacleGrid[i][0] == 1 ? 0 : path[i - 1][0];
        
        for (int j = 1; j < n; ++j)
        	path[0][j] = obstacleGrid[0][j] == 1 ? 0 : path[0][j - 1];
        
        for (int i = 1; i < m; ++i)
        	for (int j = 1; j < n; ++j) 
        		path[i][j] = obstacleGrid[i][j] == 1 ? 0 : path[i - 1][j] + path[i][j - 1];
        
        return path[m - 1][n - 1];
    }
}
