package answer;

public class RemoveDuplicatesFromSortedArray {
	/**
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	 */
	public int removeDuplicates(int[] A) {
        if (A.length < 2)
            return A.length;
            
        int temp = A[0];
        int count = 0;
        for (int i = 1; i < A.length; i ++) {
            if (A[i] == temp) {
                count ++;
            } else {
                temp = A[i];
            }
            A[i - count] = A[i];
        }
        
        return A.length - count;
    }
}
