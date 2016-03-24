package hihocoder;

import java.util.Scanner;

/**
 * http://hihocoder.com/problemset/problem/1043
 * Created by wyq on 3/24/16.
 */
public class CompleteBackpack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        int[] need  = new int[n + 1];
        int[] value = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            need[i]  = input.nextInt();
            value[i] = input.nextInt();
        }

        int[][] result = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                int temp = result[i - 1][j];
                for (int k = 1; k * need[i] <= j; ++k) {
                    temp = Math.max(result[i - 1][j], result[i - 1][j - k * need[i]] + k * value[i]);
                }
                result[i][j] = temp;
            }
        }

        System.out.println(result[n][m]);
    }
}
