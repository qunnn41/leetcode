package jobhunting;

import java.util.Scanner;

/**
 * Created by wyq on 22/09/2016.
 */
public class Hulu_autumn_3 {
    private static int step = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = Integer.parseInt(in.nextLine().split(" ")[0]);
        for (int index = 1; index <= number; index ++) {
            String[] input = in.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int L = Integer.parseInt(input[2]);
            int s = Integer.parseInt(input[3]);
            String[] str = new String[n];
            boolean[][] record = new boolean[n][m];
            for (int i = 0; i < n; i ++) {
                str[i] = in.nextLine();
            }

            char[][]map = new char[n][m];
            for (int i = 0; i < n; ++i) {
                map[i] = str[i].toCharArray();
            }

            step = 0;
            dfs(map, record, L, s, n, m, n - 1, 0);
            System.out.println("Test Case " + index + ": " + step);
        }
    }

    private static void dfs(char[][] map, boolean[][] record, int L, int s, int n, int m, int x, int y) {
        if (x > -1 && x < n && y > -1 && y < m && !record[x][y]) {
            record[x][y] = true;
            if (map[x][y] == '#') {
                step ++;
                // go right
                dfs(map, record, L, s, n, m, x, y + 1);
                dfs(map, record, L, s, n, m, x, y - 1);
                // go up
                for (int i = 1; i <= L; ++i) {
                    dfs(map, record, L, s, n, m, x - i, y);
                    dfs(map, record, L, s, n, m, x + i, y);
                }
                // jump
                if (s >= 0) {
                    if (y + 2 < m) {
                        if (map[x][y + 1] == '-' && map[x][y + 2] == '#') {
                            dfs(map, record, L, s - 1, n, m, x, y + 2);
                        }
                    }

                    if (y - 2 > -1) {
                        if (map[x][y - 1] == '-' && map[x][y - 2] == '#') {
                            dfs(map, record, L, s - 1, n, m, x, y - 2);
                        }
                    }
                }
            }
        }
    }
}
