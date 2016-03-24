package hihocoder;

import java.util.Scanner;

/**
 * http://hihocoder.com/problemset/problem/1037
 * Created by wyq on 3/24/16.
 */
public class DigitTranigle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] coupon = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                coupon[i][j] = input.nextInt();
            }
        }
        int[][] result = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (i == 0 && j == 0) {
                    result[i][j] = coupon[i][j];
                } else if (j == 0) {
                    result[i][j] = result[i - 1][j] + coupon[i][j];
                } /*else if (i == j) {
                    result[i][j] = result[i - 1][j - 1] + coupon[i][j];
                }*/ else {
                    result[i][j] = Math.max(result[i - 1][j], result[i - 1][j - 1]) + coupon[i][j];
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; ++i)
            ans = Math.max(ans, result[n - 1][i]);
        System.out.println(ans);
    }
}

//import java.util.Scanner;
//
///**
// * http://hihocoder.com/problemset/problem/1037
// * Created by wyq on 3/24/16.
// */
//public class Main {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        int[][] coupon = new int[n][n];
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j <= i; ++j) {
//                coupon[i][j] = input.nextInt();
//            }
//        }
//        int[][] result = new int[n][n];
//        for (int i = 0; i < n; ++i)
//            result[n - 1][i] = coupon[n - 1][i];
//
//        for (int i = n - 2; i > -1; --i) {
//            for (int j = i; j > -1; --j) {
//                result[i][j] = Math.max(result[i + 1][j], result[i + 1][j + 1]) + coupon[i][j];
//            }
//        }
//        System.out.println(result[0][0]);
//    }
//}

