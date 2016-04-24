package answer;

public class SearchForARange {
	/**
	 * https://leetcode.com/problems/search-for-a-range/
	 */
	public int[] searchRange(int[] nums, int target) {
		int n = nums.length - 1;
		return new int[]{GetFirst(nums, target, 0, n), GetLast(nums, target, 0, n)};
	}

	private int GetFirst(int[] nums, int target, int start, int end) {
		if (start > end)
			return -1;
		while (start < end) {
			int mid = start + ((end - start) >> 1);
			System.out.println(start + "\t" + end + "\t" + mid);
			if (nums[mid] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		System.out.println(start);
		return nums[start] == target ? start : -1;
	}

	private int GetLast(int[] nums, int target, int start, int end) {
		if (start > end)
			return -1;
		while (start < end) {
			int mid = start + ((end - start + 1) >> 1);
			if (nums[mid] <= target) {
				start = mid;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(end);
		return nums[end] == target ? end : -1;
	}
}
