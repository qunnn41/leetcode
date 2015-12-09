package answer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CountOfSmallNumbersAfterSelf {
    /**
     * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
     */
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new LinkedList<Integer>();
        }
        LinkedList<Integer> result = new LinkedList<Integer>();
        int n = nums.length;
        Integer[] temp = new Integer[n];
        temp[n - 1] = 0;
        for (int i = n - 2; i > -1; --i) {
            int j = i + 1;
            while (j < n) {
                if (nums[j] < nums[i])
                    break;
                j ++;
            }
            temp[i] = (j == n) ? 0 : temp[j] + 1;
        }

        return Arrays.asList(temp);
    }

    public static void main(String[] args) {
        System.out.println(new CountOfSmallNumbersAfterSelf().countSmaller(new int[] {2,0,1}));
    }
}
