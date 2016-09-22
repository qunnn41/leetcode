package jobhunting;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by wyq on 22/09/2016.
 */
public class Hulu_autumn_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int maxLength = -1;
        String maxString = null;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < str.length; ++i) {
            for (int j = i + 1; j < str.length; ++j) {
                String temp1 = str[i] + str[j];
                String temp2 = str[j] + str[i];
                set.add(temp1);
                set.add(temp2);
            }
        }

        for (int i = 0; i < str.length; ++i) {
            if (set.contains(str[i]) && str[i].length() > maxLength) {
                maxString = str[i];
                maxLength = str[i].length();
            }
        }

        System.out.println(maxString);
    }
}
