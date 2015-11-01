package answer;

public class SearchInRotatedSortedArrayII {
	/**
	 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
	 */
	public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
        	while (l < r && nums[l] == nums[l + 1]) l++;
        	while (l < r && nums[r] == nums[r - 1]) r--;
        	int mid = (l + r) / 2;
        	if (target == nums[mid])
        		return true;
        	if (nums[mid] > target) {
        		if (nums[l] <= target || nums[mid] < nums[l])
        			r = mid - 1;
        		else
        			l = mid + 1;
        	} else {
        		if (nums[l] > target || nums[mid] > nums[l])
        			l = mid + 1;
        		else
        			r = mid - 1;
        	}
        }
        
        return false;
    }
}
