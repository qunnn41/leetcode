package answer;

public class SpiralMatrixII {
	/**
	 * https://leetcode.com/problems/spiral-matrix-ii/
	 */
	public int[][] generateMatrix(int n) {
        //0 -> right
        //1 -> down
        //2 -> left
        //3 -> up
        int direction = 0;
        int[][]result = new int[n][n];
        int i = 0, j = 0, index = 1;
        while (index <= n * n) {
            result[i][j] = index;
            if (direction == 0) {
                if (j < n - 1 && result[i][j + 1] == 0) {
                    //move right
                    ++j;
                } else {
                    //turn down
                    direction = 1;
                    ++i;
                }
            } else if (direction == 1) {
                if (i < n - 1 && result[i + 1][j] == 0) {
                    //move down;
                    ++i;
                } else {
                    //turn left
                    direction = 2;
                    --j;
                }
            } else if (direction == 2) {
                if (j > 0 && result[i][j - 1] == 0) {
                    //move left
                    --j;
                } else {
                    //turn up
                    direction = 3;
                    --i;
                }
            } else {
                if (i > 0 && result[i - 1][j] == 0) {
                    //move up
                    --i;
                } else {
                    direction = 0;
                    ++j;
                }
            }
            
            ++index;
        }
        
        return result;
    }
}
