package jobhunting;
import java.util.*;

/**
 * Created by wyq on 4/7/16.
 */
public class Huawei_FX_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[][]dis = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                dis[i][j] = input.nextInt();
            }
        }

        HashSet<Integer> reachable = new HashSet<>();
        int result = 0;
        reachable.add(0);

        while (reachable.size() < N) {
            int minDis = Integer.MAX_VALUE;
            int minV = -1;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (i != j && reachable.contains(i) && !reachable.contains(j) && dis[i][j] < minDis) {
                        minV = j;
                        minDis = dis[i][j];
                    }
                }
            }

            reachable.add(minV);
            result += minDis;
        }

        System.out.println(result);
    }
}
