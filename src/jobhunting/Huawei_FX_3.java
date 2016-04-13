package jobhunting;
import java.util.Scanner;

/**
 * Created by wyq on 4/8/16.
 */
public class Huawei_FX_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] board = new int[10][10];
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                board[i][j] = input.nextInt();
            }
        }

        while (input.hasNext()) {
            int x = input.nextInt();
            int y = input.nextInt();
            int color = input.nextInt();

            if (board[x][y] != 0) {
                System.out.println(Integer.MAX_VALUE);
                continue;
            }

            board[x][y] = color;

            int c = 3 - color;
            int count = 0;
            for (int i = 0; i < 4; ++i) {
                int dx = x + v[i][0];
                int dy = y + v[i][1];
                if (isOnBoard(dx, dy) && board[dx][dy] == c) {
                    int[][] temp = new int[10][10];
                    if (!dfs(board, dx, dy, temp, c))
                        count += calc(board, temp);
                }
            }
            if (count != 0) {
                System.out.println(color == 2 ? count : -count);
                continue;
            }
            int[][] temp = new int[10][10];
            if (dfs(board, x, y, temp, color))
                System.out.println(0);
            else {
                board[x][y] = 0;
                System.out.println(Integer.MAX_VALUE);
            }

        }
        input.close();
    }
    private final static int[][] v = {{-1,0},{1,0},{0,-1},{0,1}};

    private static boolean isOnBoard(int dx, int dy) {
        return dx >= 0 && dx <= 9 && dy >= 0 && dy <= 9;
    }

    private static int calc(int[][] board, int[][] temp) {
        int count = 0;
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (temp[i][j] != 0) {
                    count ++;
                    board[i][j] = 0;
                }
            }
        }
        return count;
    }
    private static boolean dfs(int[][] board, int x, int y, int [][]temp, int c) {
        temp[x][y] = c;
        for (int i = 0; i < 4; ++i) {
            int dx = x + v[i][0];
            int dy = y + v[i][1];
            if (isOnBoard(dx, dy)) {
                if (board[dx][dy] == 0)
                    return true;
                if (board[dx][dy] == c && temp[dx][dy] != c) {
                    if (dfs(board, dx, dy, temp, c))
                        return true;
                }
            }
        }
        return false;
    }
}
