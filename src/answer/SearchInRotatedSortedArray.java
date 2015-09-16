package answer;

public class SearchInRotatedSortedArray {
	/**
	 * https://leetcode.com/problems/search-in-rotated-sorted-array/
	 */
	public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
        	int mid = (low + high) / 2;
        	if (nums[mid] > nums[high])
        		low = mid + 1;
        	else
        		high = mid;
        }
        
        int rotate = low;
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
        	int mid = (low + high) / 2;
        	int real = (mid + rotate) % nums.length;
        	if (nums[real] == target)
        		return real;
        	else if (nums[real] < target)
        		low = mid + 1;
        	else
        		high = mid - 1;
        }
        
        return -1;
    }
}
