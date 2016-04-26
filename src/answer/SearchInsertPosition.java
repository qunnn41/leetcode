package answer;

public class SearchInsertPosition {
	/**
	 * https://leetcode.com/problems/search-insert-position/
	 */
	public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        if (target > nums[high])
            return nums.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
