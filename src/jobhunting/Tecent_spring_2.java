package jobhunting;
import java.util.Scanner;

/**
 * Created by wyq on 4/4/16.
 */
public class Tecent_spring_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        StringBuilder sb = new StringBuilder(str);
        String str2 = sb.reverse().toString();
        System.out.println(LCS(str, str2));
    }

    private static int LCS(String p, String s) {
        char[] p_arr = p.toCharArray();
        char[] s_arr = s.toCharArray();
        int p_len = p_arr.length;
        int s_len = s_arr.length;
        int[][]dis = new int[p_len + 1][s_len + 1];

        for (int i = 1; i <= p_len; ++i) {
            for (int j = 1; j <= p_len; ++j) {
                if (p_arr[i-1] == s_arr[j-1]) {
                    dis[i][j] = dis[i-1][j-1] + 1;
                } else {
                    dis[i][j] = Math.max(dis[i-1][j], dis[i][j-1]);
                }
            }
        }

        return dis[p_len][s_len];
    }
}
