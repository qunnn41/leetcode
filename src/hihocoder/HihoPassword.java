package hihocoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * http://hihocoder.com/contest/hihointerview5/problem/1
 * Created by wyq on 3/27/16.
 */
public class HihoPassword {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");

            int index = n - 1;
            while (index != 0 && str[index].compareTo(str[index - 1]) > 0) {
                index --;
            }

            index = index == 0 ? 1 : index;
            for (int i = 0; i < index; ++i)
                System.out.print(str[i] + " ");
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
