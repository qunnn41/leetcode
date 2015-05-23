package answer;

public class MergeSortedArray {
	/**
	 * https://leetcode.com/problems/merge-sorted-array/
	 */
	public void merge(int A[], int m, int B[], int n) {
        int last = m - 1;
        int index = n - 1;
        
        while (index > -1) {
            while (last > -1 && A[last] > B[index]) --last;
            if (last == -1)
                break;
            
            for (int i = m; i > last; --i)
                A[i] = A[i - 1];
            A[last + 1] = B[index];
            --index;
            ++m;
        }
        
        for (int i = m - 1; i > -1; --i)
            A[i + index + 1] = A[i];
        for (int i = 0; i <= index; ++i)
            A[i] = B[i];
        
    }
}
