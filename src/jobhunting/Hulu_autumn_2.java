package jobhunting;

import java.util.*;

/**
 * Created by wyq on 22/09/2016.
 */
public class Hulu_autumn_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().split(" ")[0]);
        String[] name = new String[n];
        boolean[] required = new boolean[n];
        boolean[] multiple = new boolean[n];
        boolean[] minus = new boolean[n];
        String[] candidate = new String[n];
        for (int index = 0; index < n; index ++) {
            String[] input = in.nextLine().split(" ");
            name[index] = input[0];
            required[index] = Integer.parseInt(input[1]) == 1;
            multiple[index] = Integer.parseInt(input[2]) == 1;
            minus[index] = Integer.parseInt(input[3]) == 1;
            candidate[index] = in.nextLine();
        }

        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for (int index = 0; index < n; index ++) {
            map.put(index, new ArrayList<>());

            String[] str = candidate[index].split(",");
            Arrays.sort(str);
            if (multiple[index]) {
                //can have multiple values
                List<String> s = new ArrayList<>();
                helper(str, 0, "", s, name[index]);
                for (String ss : s) {
                    map.get(index).add(ss);
                }
            } else {
                for (String s : str) {
                    map.get(index).add(name[index] + "=" + s);
                }
            }

            if (minus[index]) {
                //can have "-"
                ArrayList<String> adding = new ArrayList<>();
                for (String s : map.get(index)) {
                    String[] ss = s.split("=");
                    adding.add(ss[0] + "=-" + ss[1]);
                }

                map.get(index).addAll(adding);
            }
        }

        ArrayList<String> result = new ArrayList<>();
        result.add("");
        for (int index = 0; index < n; index ++) {
            ArrayList<String> addinglist = new ArrayList<>();
            for (String front : map.get(index)) {
                if (result.size() == 0) {
                    addinglist.add(front);
                } else {
                    for (String back : result) {
                        addinglist.add(front + "&" + back);
                    }
                }
            }

            if (required[index]) {
                result.clear();
                result.addAll(addinglist);
            } else {
                result.addAll(addinglist);
            }
        }

        for (int index = 0; index < n; index ++) {
            if (required[index]) {
                result.remove("");
                break;
            }
        }

        PriorityQueue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < result.size(); ++i) {
            String[] ss = result.get(i).split("&");
            Arrays.sort(ss);
            StringBuilder sb = new StringBuilder();
            for (String str : ss) {
                sb.append(str + "&");
            }

            sb = sb.deleteCharAt(sb.length() - 1);
            queue.add(sb.toString());
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    private static void helper(String[] s, int index, String path, List<String> result, String name) {
        if (!path.equals("")) {
            result.add(name + "=" + path);
        }

        for (int i = index; i < s.length; ++i) {
            if (path.equals("")) {
                helper(s, i + 1, s[i], result, name);
            } else {
                helper(s, i + 1, path + "," + s[i], result, name);
            }
        }
    }
}
