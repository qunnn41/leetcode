package answer;

import java.util.Arrays;

public class WiggleSortII {
    /**
     * https://leetcode.com/problems/wiggle-sort-ii/
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = n % 2 == 0 ? n / 2 - 1 : n / 2;
        int[] temp = Arrays.copyOf(nums, n);

        int index = 0;
        for (int i = 0; i <= mid; ++i) {
            nums[index] = temp[mid - i];
            if (index + 1 < n)
                nums[index + 1] = temp[n - 1 - i];
            index += 2;
        }
    }
}
