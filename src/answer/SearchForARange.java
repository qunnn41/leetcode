package answer;

public class SearchForARange {
	/**
	 * https://leetcode.com/problems/search-for-a-range/
	 */
	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0)
			return new int[] {-1, -1};
		if (nums.length == 1) {
			if (nums[0] != target)
				return new int[] {-1, -1};
			else return new int[] {0, 0};
		}
		return search(nums, target, 0, nums.length - 1);
    }
	
	private int[] search(int[] nums, int target, int low, int high) {
		if (low > high)
			return new int[] {-1, -1};
		if (low == high && nums[low] != nums[high])
			return new int[] {-1, -1};
		int mid = (low + high) / 2;
		if (nums[mid] > target) {
			return search(nums, target, low, mid - 1);
		} else if (nums[mid] < target) {
			return search(nums, target, mid + 1, high);
		} else {
			int[] left = search(nums, target, low, mid - 1);
			int start = left[0];
			if (start == -1) start = mid;
			
			int[] right = search(nums, target, mid + 1, high);
			int end = right[1];
			if (end == -1) end = mid;
			
			return new int[] {start, end};
		}
	}
}
