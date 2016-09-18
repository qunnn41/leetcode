package jobhunting;

import java.util.Scanner;

/**
 * Created by wyq on 18/09/2016.
 */
public class NeteaseGame_autumn_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().split(" ")[0]);
        while (n -- > 0) {
            char[][] board = new char[8][8];
            for (int i = 0; i < 8; ++i) {
                board[i] = in.nextLine().toCharArray();
            }

            int step = Integer.parseInt(in.nextLine().split(" ")[0]);
            while (step -- > 0) {
                String[] location = in.nextLine().split(" ");
                int x = Integer.parseInt(location[0]);
                int y = Integer.parseInt(location[1]);
                int color = Integer.parseInt(location[2]);
                if (color == 0) {
                    board[x][y] = '*';
                    helper(board, x, y, '*');
                } else {
                    board[x][y] = 'o';
                    helper(board, x, y, 'o');
                }
            }

            int black_color = 0;
            int white_color = 0;
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (board[i][j] == '*') {
                        black_color ++;
                    } else if (board[i][j] == 'o') {
                        white_color ++;
                    }
                }
            }

            System.out.println(black_color + " " + white_color);
        }
    }

    private static void helper(char[][] board, int x, int y, char color) {
        int[] dx = new int[]{-1, 1, 0,  0, -1, -1, 1, 1};
        int[] dy = new int[]{ 0, 0, 1, -1, -1,  1, -1, 1};
        for (int direction = 0; direction < 8; ++direction) {
            for (int step = 1; ; step ++){
                int xx = x + step * dx[direction];
                int yy = y + step * dy[direction];
                if (xx > -1 && xx < 8 && yy > -1 && yy < 8) {
                    //onboard
                    if (board[xx][yy] == '.') {
                        break;
                    }

                    if (board[xx][yy] == color) {
                        for (int i = 1; i <= step; ++i) {
                            board[x + i * dx[direction]][y + i * dy[direction]] = color;
                        }

                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }
}
