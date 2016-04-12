import java.util.Scanner;

/**
 * Created by wyq on 4/6/16.
 */
public class Microsoft_spring_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine().split(" ")[0]);
        while (n-- > 0) {
            String[] str = input.nextLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int P = Integer.parseInt(str[1]);
            int W = Integer.parseInt(str[2]);
            int H = Integer.parseInt(str[3]);

            String[] str2 = input.nextLine().split(" ");
            int[] a = new int[N];

            for (int i = 0; i < N; ++i)
                a[i] = Integer.parseInt(str2[i]);

            int size = 1;
            boolean flag = true;
            while (flag) {
                int each_line = W / size;
                int each_page = H / size;
                if (each_line == 0 || each_page == 0) {
                    System.out.println(size - 1);
                    break;
                }
                int max = P * each_page;
                int current = 0;
                for (int j = 0; j < N; ++j) {
                    int single = (a[j] + each_line - 1) / each_line;
                    current += single;
                    if (current > max) {
                        System.out.println(size - 1);
                        flag = false;
                        break;
                    }
                }
                size ++;
            }
        }
    }
}
