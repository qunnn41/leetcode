package jobhunting;

import java.util.Scanner;

/**
 * Created by wyq on 18/09/2016.
 */
public class NeteaseGame_autumn_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().split(" ")[0]);
        while (n -- > 0) {
            String[] str = in.nextLine().split(" ");
            int k = Integer.parseInt(str[0]);
            char[] array = str[1].toCharArray();
            int max = 0;
            for (int i = 0; i <= array.length - k; ++i) {
                //change string
                for (int j = i; j < k + i; ++j) {
                    if (array[j] == '1') {
                        array[j] = '0';
                    } else {
                        array[j] = '1';
                    }
                }

                max = Math.max(max, maxZeroLength(array));

                //change back
                for (int j = i; j < k + i; ++j) {
                    if (array[j] == '1') {
                        array[j] = '0';
                    } else {
                        array[j] = '1';
                    }
                }
            }

            System.out.println(max);
        }
    }

    private static int maxZeroLength(char[] array) {
        int[] record = new int[array.length];
        record[0] = array[0] == '0' ? 1 : 0;
        for (int i = 1; i < record.length; ++i) {
            record[i] = array[i] == '0' ? record[i - 1] + 1 : 0;
        }

        int max = -1;
        for (int i = 0; i < record.length; ++i) {
            max = Math.max(record[i], max);
        }

        return max;
    }
}
