package jobhunting;

import java.util.HashSet;

/**
 * Created by wyq on 2016/9/28.
 */
public class Airbnb_autumn_1 {
    public static void main(String[] args) {
        String[] str = paginate(5, new String[]{
                "1,8,207.1,Melbourne",
                "1,10,206.1,Melbourne",
                "1,29,204.1,Melbourne",
                "1,21,202.1,Melbourne",
                "8,18,201.1,Melbourne",
                "8,30,200.1,Melbourne",
                "7,11,199.1,Melbourne"
        });

        for (String s : str) {
            System.out.println(s);
        }
    }

    static String[] paginate(int num, String[] results) {
        if (results == null || results.length < 2) {
            return results;
        }

        int page_number = (results.length - 1) / num;
        String[] output = new String[results.length + page_number];
        int pointer_output = 0;
        int pointer_result = 0;
        HashSet<Integer> set = new HashSet<>();
        boolean[] record = new boolean[results.length];
        int content = 0;
        while (pointer_output < output.length) {
            if (!record[pointer_result]) {
                int host_id = Integer.parseInt(results[pointer_result].split(",")[0]);
                if (!set.contains(host_id)) {
                    output[pointer_output ++] = results[pointer_result];
                    content ++;
                    record[pointer_result] = true;
                    set.add(host_id);

                    pointer_result = (pointer_result + 1) % results.length;
                    if (pointer_result == 0) {
                        set.clear();
                    }

                    if (content % num == 0 && pointer_output < output.length) {
                        output[pointer_output ++] = "";
                        set.clear();
                        content = 0;
                        pointer_result = 0;
                    }
                } else {
                    pointer_result = (pointer_result + 1) % results.length;
                    if (pointer_result == 0) {
                        set.clear();

                    }
                }
            } else {
                pointer_result = (pointer_result + 1) % results.length;
                if (pointer_result == 0) {
                    set.clear();
                }
            }
        }

        return output;
    }
}
