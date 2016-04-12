import java.util.Scanner;

/**
 * Created by wyq on 4/6/16.
 */
public class Microsoft_spring_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] str = input.nextLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int[] allow = new int[N];
        int[] deny = new int[N];
        int[] mask = new int[N];
        for (int i = 0; i < N; ++i) {
            String[] rule = input.nextLine().split(" ");
            String[] ip = rule[1].split("\\.");
            if (ip[3].indexOf('/') != -1) {
                String[] part = ip[3].split("/");
                mask[i] = Integer.parseInt(part[1]);
                ip[3] = part[0];
//                System.out.println("mask:" + mask[i]);
            } else {
                mask[i] = -1;
            }

            int ip_int = 0;
            for (int j = 0; j < 4; ++j) {
                ip_int = ip_int << 8 | Integer.parseInt(ip[j]);
//                System.out.println(ip_int + "\t" + Integer.parseInt(ip[j]));
            }
//            System.out.println(Integer.toHexString(ip_int));

            if (rule[0].equals("allow")) {
                deny[i] = -1;
                allow[i] = ip_int;
            } else {
                allow[i] = -1;
                deny[i] = ip_int;
            }
        }

        for (int i = 0; i < M; ++i) {
            String[] ip = input.nextLine().split("\\.");
            int ip_int = 0;
            for (int j = 0; j < 4; ++j) {
                ip_int = ip_int << 8 | Integer.parseInt(ip[j]);
            }
//            System.out.println(Integer.toHexString(ip_int));

            int j = 0;
            for (; j < N; ++j) {
                if (mask[j] != -1) {
                    //has mask
                    int index = 32 - mask[j];
                    if (allow[j] != -1) {
                        if (ip_int >> index == allow[j] >> index || allow[j] == 0) {
                            System.out.println("YES");
                            break;
                        }
                    } else {
                        if (ip_int >> index == deny[j] >> index || deny[j] == 0) {
                            System.out.println("NO");
                            break;
                        }
                    }
                } else {
                    //not have mask
                    if (allow[j] != -1) {
                        if (ip_int == allow[j]) {
                            System.out.println("YES");
                            break;
                        }
                    } else {
                        if (ip_int == deny[j]) {
                            System.out.println("NO");
                            break;
                        }
                    }
                }
            }
            if (j == N)
                System.out.println("YES");
        }
    }
}
