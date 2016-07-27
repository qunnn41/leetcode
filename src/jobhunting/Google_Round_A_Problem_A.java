package jobhunting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.*;

/**
 * Created by wyq on 7/10/16.
 */
public class Google_Round_A_Problem_A {
    public static void main(String[] args) throws Exception {
        File f = new File("A-small-attempt4.in");
        FileInputStream inputStream = new FileInputStream(f);
        Scanner input = new Scanner(inputStream);
        FileWriter fileWriter = new FileWriter(new File("A-small-attempt4.out"));
        int n = Integer.parseInt(input.nextLine().split(" ")[0]);
        int r_no = 0;

        while (n -- > 0) {
            int size = Integer.parseInt(input.nextLine().split(" ")[0]);
            String[] name = new String[size];
            String[] result = new String[size];
            Map<String, String> map = new HashMap<String, String>();

            for (int i = 0; i < size; ++i) {
                name[i] = input.nextLine();
                result[i] = removeDuplicateLetters(name[i].replace(" ", ""));
                char[] array = result[i].toCharArray();
                Arrays.sort(array);
                result[i] = new String(array);
                map.put(result[i], name[i]);
            }

            Arrays.sort(result, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() != o2.length()) {
                        return o2.length() - o1.length();
                    }

                    return o1.compareTo(o2);
                }
            });

//            System.out.println("\n\n\nResult");
//            for (int i = 0; i < size; ++i)
//                System.out.println(result[i]);
//            System.out.println("\n\n\n");

            fileWriter.write("Case #" + (++r_no) + ": " + map.get(result[0]) + "\n");
            fileWriter.flush();
        }

        inputStream.close();
        fileWriter.close();
    }

    private static String removeDuplicateLetters(String s) {
        if (s.length() < 2)
            return s;
        int[] c = new int[26];
        for (int i = 0; i < s.length(); ++i)
            c[s.charAt(i) - 'A'] ++;
        int pos = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) < s.charAt(pos))
                pos = i;
            if (-- c[s.charAt(i) - 'A'] == 0)
                break;
        }

        return s.charAt(pos) + removeDuplicateLetters(s.substring(pos).replace(s.charAt(pos) + "", ""));
    }
}
