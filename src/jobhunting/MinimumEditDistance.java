package jobhunting;

/**
 * Created by wyq on 4/13/16.
 */
public class MinimumEditDistance {
    public void dis(String S, String T) {
        char[] s_arr = S.toCharArray();
        char[] t_arr = T.toCharArray();
        int s_len = s_arr.length, t_len = t_arr.length;
        int[][]dis = new int[s_len+1][t_len+1];

        for (int i = 0; i <= s_len; ++i)
            dis[i][0] = i;

        for (int j = 0; j <= t_len; ++j)
            dis[0][j] = j;

        for (int i = 1; i <= s_len; ++i)
            for (int j = 1; j <= t_len; ++j)
                if (s_arr[i-1] == t_arr[j-1])
                    dis[i][j] = dis[i-1][j-1];
                else
                    dis[i][j] = Math.min(Math.min(dis[i-1][j], dis[i][j-1]), dis[i-1][j-1]) + 1;

        System.out.println(dis[s_len][t_len]);
    }
    public static void main(String[] args) {
        new MinimumEditDistance().dis("appropriate meaning", "approximate matchingM");    }
}
