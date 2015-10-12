package answer;

public class HIndexII {
	/**
	 * https://leetcode.com/problems/h-index-ii/
	 */
	public int hIndex(int[] citations) {
		if(citations == null || citations.length == 0) return 0;
		int low = 0, high = citations.length - 1;
		int n = citations.length;
		
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (citations[mid] == n - mid)
				return n - mid;
			else if (citations[mid] < n - mid)
				low = mid + 1;
			else
				high = mid - 1;
		}
		
		return n - high - 1;
    }
}
