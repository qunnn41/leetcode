package jobhunting;

import java.util.Scanner;

/**
 * Created by wyq on 18/09/2016.
 */
public class NeteaseGame_autumn_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().split(" ")[0]);
        while (n -- > 0) {
            String[] input = in.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int L = Integer.parseInt(input[1]);

            input = in.nextLine().split(" ");
            int[] gift = new int[L];
            for (int i = 0; i < L; ++i) {
                gift[i] = Integer.parseInt(input[i]);
            }

            if (L >= N) {
                boolean result = false;
                for (int i = 0; i < N; ++i) {
                    boolean flag = false;
                    //ignore first i elements
                    for (int k = 0; i + k * N < L; k ++) {
                        boolean[] exist = new boolean[N + 1];
                        for (int j = 0; j < N; ++j) {
                            int current = i + k * N + j;
                            if (current < L) {
                                if (exist[gift[current]]) {
                                    flag = true;
                                    break;
                                } else {
                                    exist[gift[current]] = true;
                                }
                            } else {
                                break;
                            }
                        }
                    }

                    if (!flag) {
                        //check first i elements
                        boolean[] exist = new boolean[N + 1];
                        for (int j = 0; j < i; ++j) {
                            if (exist[gift[j]]) {
                                flag = true;
                                break;
                            } else {
                                exist[gift[j]] = true;
                            }
                        }

                        if (!flag && !result) {
                            System.out.println("CAN\'T DECIDE");
                            result = true;
                        }
                    }
                }

                if (!result) {
                    System.out.println("B");
                }


            } else {
                // same data will not exist more than twice
                boolean flag = false;
                int[] exist = new int[N + 1];
                int i = 0;
                for (; i < L; ++i) {
                    if (exist[gift[i]] > 1) {
                        flag = true;
                        break;
                    } else {
                        exist[gift[i]] ++;
                    }
                }

                if (flag) {
                    System.out.println("B");
                } else {
                    System.out.println("CAN'T DECIDE");
                }
            }
        }
    }
}
