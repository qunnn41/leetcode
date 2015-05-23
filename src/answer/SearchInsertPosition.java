package answer;

public class SearchInsertPosition {
	/**
	 * https://leetcode.com/problems/search-insert-position/
	 */
	public int searchInsert(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        if (target < A[low]) return low;
        if (target > A[high]) return high + 1;
        
        while (low + 1 < high) {
            int mid = (high + low) / 2;
            if (target < A[mid]) {
                high = mid;
            } else if (target > A[mid]) {
                low = mid;
            } else
                return mid;
        }
        
        if (target <= A[low]) return low;
        return low + 1;
    }
}
