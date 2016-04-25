package answer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CountOfSmallNumbersAfterSelf {
    /**
     * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
     */
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Tuple[] array = new Tuple[n];
        for (int i = 0; i < n; ++i)
            array[i] = new Tuple(nums[i], i);
        sort(ans, array, n);
        List<Integer> result = new LinkedList<Integer>();
        for (int x : ans)
            result.add(x);
        return result;
    }

    private Tuple[] sort(int[] ans, Tuple[] a, int n) {
        if (n <= 1)
            return a;
        int i = n / 2, j = n - i;
        Tuple[] left = sort(ans, Arrays.copyOfRange(a, 0, i), i);
        Tuple[] right = sort(ans, Arrays.copyOfRange(a, i, n), j);

        for (int k = n - 1; k > -1; --k) {
            if (j == 0 || (i > 0 && left[i - 1].val > right[j - 1].val)) {
                ans[left[i - 1].idx] += j;
                a[k] = left[--i];
            } else {
                a[k] = right[--j];
            }
        }

        return a;
    }

    class Tuple {
        int val;
        int idx;
        public Tuple(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
