package answer;

public class FindPeakElement {
	/**
	 * https://leetcode.com/problems/find-peak-element/
	 */
	
	public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if (mid < nums.length - 1  && nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                end = mid;
            }
        }
        return start;
    }
}
