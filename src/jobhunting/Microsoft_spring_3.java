package jobhunting;
import java.util.Scanner;

/**
 * Created by wyq on 4/6/16.
 */
public class Microsoft_spring_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] str = input.nextLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int[][] maze = new int[N+2][M+2];
        for (int i = 0; i < N; ++i) {
            String s = input.nextLine();
            char[]array = s.toCharArray();
            for (int j = 0; j < M; ++j)
                //0 .
                //1 b
                maze[i][j] = array[j] == '.' ? 0 : 1;
        }

        for (int i = 0; i <= N; ++i)
            maze[i][M] = 1;

        for (int j = 0; j <= M; ++j)
            maze[N][j] = 1;

        int INF = 10000;
        //0 top
        //1 left
        int[][][] dis = new int[N][M][2];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                dis[i][j][0] = INF;
                dis[i][j][1] = INF;
            }
        }

        dis[0][0][0] = 0;
        dis[0][0][1] = 1 - maze[0][1];

        for (int i = 1; i < M; ++i) {
            dis[0][i][0] = dis[0][i-1][0]+maze[0][i];
        }

        for (int i = 1; i < N; ++i) {
            dis[i][0][1] = dis[i-1][0][1]+maze[i][0];
        }

        for (int i = 1; i < N; ++i) {
            for (int j = 1; j < M; ++j) {
                dis[i][j][0] = maze[i][j] + Math.min(dis[i][j-1][0], dis[i][j-1][1] + 1 - maze[i+1][j-1]);
                dis[i][j][1] = maze[i][j] + Math.min(dis[i-1][j][1], dis[i-1][j][0] + 1 - maze[i-1][j+1]);
            }
        }
        System.out.println(Math.min(dis[N-1][M-1][0], dis[N-1][M-1][1]));
    }
}
