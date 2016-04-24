package answer;

public class WordSearch {
	/**
	 * https://leetcode.com/problems/word-search/
	 */
	private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][];
        for (int i = 0; i < board.length; i ++) {
            visited[i] = new boolean[board[i].length];
            for (int j = 0; j < visited[i].length; j ++)
                visited[i][j] = false;
        }
            
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                if (current(board, i, j, word) == true)
                    return true;
            }//end for
        }//end for
        
        return false;
    }
    
    private boolean OnBoard(char[][] board, int x, int y) {
        if (x < 0)
            return false;
        if (y < 0)
            return false;
        if (x >= board.length)
            return false;
        if (y >= board[x].length)
            return false;
        return true;
    }
    
    private boolean current(char[][] board, int x, int y, String word) {
        if (word.length() == 0 || word == null)
            return true;
            
        if (OnBoard(board, x, y)) {
            if (visited[x][y] == false && board[x][y] == word.charAt(0)) {
                visited[x][y] = true;
                boolean flag = false;
                String remain = word.substring(1);
                if (current(board, x - 1, y, remain))
                    flag = true;
                else if (current(board, x + 1, y, remain))
                    flag = true;
                else if (current(board, x, y + 1, remain))
                    flag = true;
                else if (current(board, x, y - 1, remain))
                    flag = true;
                visited[x][y] = false;
                return flag;
            }
        }
        
        return false;
    }
}
