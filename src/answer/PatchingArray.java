package answer;

public class PatchingArray {
    /**
     * https://leetcode.com/problems/patching-array/
     */
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int added = 0, i = 0;
        int length = nums.length;
        while (miss <= n) {
            if (i < length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                added ++;
            }
        }
        return added;
    }
}
