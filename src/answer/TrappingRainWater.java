package answer;

public class TrappingRainWater {
	/**
	 * https://leetcode.com/problems/trapping-rain-water/
	 */
	public int trap(int[] A) {
        if (A.length < 3)
            return 0;
        int l = 0;
        int r = A.length - 1;
        while (l < r && A[l] <= A[l + 1]) l ++;
        while (l < r && A[r] <= A[r - 1]) r --;
        
        int result = 0;
        while (l < r) {
            int left = A[l];
            int right = A[r];
            if (left <= right) {
                while (l < r && left >= A[++ l])
                    result += left - A[l];
            } else {
                while (l < r && right >= A[-- r])
                    result += right - A[r];
            }//end if
        }//end while
        return result;
    }
}
