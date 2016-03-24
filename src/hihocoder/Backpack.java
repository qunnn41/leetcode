package hihocoder;

import java.util.Scanner;

/**
 * http://hihocoder.com/problemset/problem/1038
 * Created by wyq on 3/24/16.
 */
public class Backpack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        int[] dp = new int[m + 1];
        for (int i = 0; i < n; ++i) {
            int need = input.nextInt();
            int value = input.nextInt();
            for (int j = m; j >= need; --j)
                dp[j] = Math.max(dp[j], dp[j - need] + value);
        }

        System.out.println(dp[m]);
    }
}

