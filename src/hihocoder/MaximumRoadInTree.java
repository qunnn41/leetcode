package hihocoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * http://hihocoder.com/problemset/problem/1050
 * Created by wyq on 3/24/16.
 */
public class MaximumRoadInTree {
    private static int max = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<Integer>[] edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; ++i)
            edges[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; ++i) {
            int first = input.nextInt();
            int second = input.nextInt();
            edges[first].add(second);
            edges[second].add(first);
        }
        helper(1, edges, new boolean[n + 1]);
        System.out.println(max);
    }

    private static int helper(int current, List<Integer>[] edges, boolean[] visited) {
        int one = 0;
        int two = 0;
        visited[current] = true;
        for (int next : edges[current]) {
            if (!visited[next]) {
                int height = helper(next, edges, visited) + 1;
                if (height > one) {
                    two = one;
                    one = height;
                } else if (height > two) {
                    two = height;
                }
            }
        }

        max = Math.max(one + two, max);
        return one;
    }
}
