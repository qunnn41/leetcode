package hihocoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * http://hihocoder.com/contest/hihointerview5/problem/2
 * Created by wyq on 3/27/16.
 */
public class CommonDivisor {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            int M = Integer.parseInt(str[0]);
            int N = Integer.parseInt(str[1]);
            HashSet<Integer> m_d = new HashSet<>();
            HashSet<Integer> n_d = new HashSet<>();

            for (int i = 1; i <= (int) Math.sqrt(M); ++i) {
                if (M % i == 0) {
                    m_d.add(i);
                    m_d.add(M / i);
                }
            }

            int count = 0;
            for (int i = 1; i <= (int) Math.sqrt(N); ++i) {
                if (N % i == 0) {
                    n_d.add(i);
                    n_d.add(N / i);

                    if (m_d.contains(i))
                        count++;
                    if (i * i != N && m_d.contains(N / i))
                        count++;
                }
            }

            long t = 1;
            int total = m_d.size() * n_d.size();
            int gcd = gcd(total, count);
            System.out.print((total / gcd) + " " + (count / gcd));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}