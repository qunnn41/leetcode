package jobhunting;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wyq on 3/18/16.
 * http://hihocoder.com/contest/ntest2016spring1/problem/1
 */
public class NeteaseGame_spring_1 {
    private static int[] digit = new int[] {0xee, 0xc8, 0xba, 0xda, 0x5c, 0xd6, 0xf6, 0x4a, 0xfe, 0xde};
    private static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int S = in.nextInt();
        ArrayList<ArrayList<Integer>> candidate = new ArrayList<>();
        while (S-- > 0) {
            count = 0;
            candidate.clear();
            int K = in.nextInt();
            int N = in.nextInt();
            String str = in.nextLine();
            int[] lightNumber = new int[K];
            int index = 0;
            while (index < K) {
                str = in.nextLine();
                char[] array = str.trim().toCharArray();
                for (char ch : array) {
                    if (Character.isDigit(ch)) {
                        lightNumber[index] |= (1 << (ch - '0'));
                    }
                }

                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < 10; ++i) {
                    if ((lightNumber[index] & digit[i]) == lightNumber[index]) {
                        list.add(i);
                    }
                }
                candidate.add(list);
                index ++;
            }
            calculate(candidate, 0, "", N);

            System.out.println(count);
        }
    }

    private static void calculate(ArrayList<ArrayList<Integer>> data, int index, String current, int N) {
        if (current.length() == data.size()) {
            if (Integer.parseInt(current) < N) {
//                System.out.println(current);
                count ++;
            }
            return;
        }
        int num = current.length();
        for (int i = index; i < data.get(num).size(); ++i) {
            current += data.get(num).get(i);
            calculate(data, 0, current, N);
            current = current.substring(0, current.length() - 1);
        }
    }
}
