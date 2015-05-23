package answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrayCode {
    /**
     * https://leetcode.com/problems/gray-code/
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < Math.pow(2, n); ++i)
            result.add((i >> 1) ^ i);
        return result;
    }

    public List<Integer> grayCode2(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (n == 0) {
            result.add(0);
        } else {
            List<Integer> list1 = grayCode(n - 1);
            List<Integer> list2 = new ArrayList<Integer>();
            for (int num : list1)
                list2.add(num + (int)Math.pow(2, n - 1));
            Collections.reverse(list2);
            result.addAll(list1);
            result.addAll(list2);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> r = new GrayCode().grayCode(5);
        for (int n : r)
            System.out.println(n + "\t" + Integer.toBinaryString(n));
    }
}
