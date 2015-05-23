package answer;

public class MedianOfTwoSortedArray {
	/**
	 * https://leetcode.com/problems/median-of-two-sorted-arrays/
	 */
	public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        int k = (m + n + 1) / 2;
        
        double v = findKth(A, 0, m - 1, B, 0, n - 1, k);
        if ((m + n) % 2 == 0) {
            double v2 = findKth(A, 0, m - 1, B, 0, n - 1, k + 1);
            v = (v + v2) * 0.5;
        }
        
        return v;
    }
    
    private double findKth(int A[], int aL, int aR, int B[], int bL, int bR, int k) {
        if (aL > aR) return B[bL + k - 1];
        if (bL > bR) return A[aL + k - 1];
        
        int aM = (aL + aR) / 2;
        int bM = (bL + bR) / 2;
        
        if (A[aM] < B[bM]) {
            if (k <= (aM - aL) + (bM - bL) + 1) 
                return findKth(A, aL, aR, B, bL, bM - 1, k);
            else
                return findKth(A, aM + 1, aR, B, bL, bR, k - (aM - aL) - 1);
        } else {
            if (k <= (aM - aL) + (bM - bL) + 1)
                return findKth(A, aL, aM - 1, B, bL, bR, k);
            else
                return findKth(A, aL, aR, B, bM + 1, bR, k - (bM - bL) - 1);
        }
    }
}
