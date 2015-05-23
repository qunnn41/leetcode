package answer;

public class FindMinimumInRotatedSortedArray {
	/**
	 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
	 */
	public int findMin(int[] num) {
        int low = 0, high = num.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (num[mid] < num[high])
                high = mid;
            else
                low = mid + 1;
        }
        return num[low];
    }
}
