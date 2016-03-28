package hihocoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * http://hihocoder.com/contest/hihointerview5/problem/3
 * Created by wyq on 3/27/16.
 */
public class IQContest {
    public static int min;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine().split(" ")[0]);
            while (n -- > 0) {
                String[] str = br.readLine().split(" ");
                int N = Integer.parseInt(str[0]);
                int M = Integer.parseInt(str[1]);
                int S = Integer.parseInt(str[2]);
                int T = Integer.parseInt(str[3]);
                int[] score = new int[N];
                str = br.readLine().split(" ");
                for (int i = 0; i < N; ++i) {
                    score[i] = Integer.parseInt(str[i]);
                }
                min = M;
                helper(score, 0, M, S, T, 0);
                System.out.println(min);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void helper(int[] score, int quiz, int remain, int S, int T, int right) {
        if (quiz == score.length) {
            min = Math.min(right, min);
            return;
        }
        int num = (int)Math.ceil((score[quiz] * 1.0)/ S);
        int[] wrong = new int[num + 1];
        for (int i = 0; i <= num; ++i) {
            wrong[i] = (int)Math.ceil((score[quiz] - i * S) * 1.0 / T);
        }

        for (int i = 0; i <= num; ++i) {
            if (i + wrong[i] <= remain)
                helper(score, quiz + 1, remain - i - wrong[i], S, T, right + i);
        }
    }
}
