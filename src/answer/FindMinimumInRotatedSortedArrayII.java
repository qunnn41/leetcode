package answer;

public class FindMinimumInRotatedSortedArrayII {
	/**
	 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
	 */
	public int findMin(int[] num) {
        int low = 0, high = num.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (num[mid] < num[high])
                high = mid;
            else if (num[mid] > num[high])
                low = mid + 1;
            else
                high --;
        }
        return num[low];
    }
}
