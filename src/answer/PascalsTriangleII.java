package answer;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
	/**
	 * https://leetcode.com/problems/pascals-triangle-ii/
	 */
	public List<Integer> getRow(int rowIndex) {
        int[] num = new int[rowIndex + 1];
        num[0] = 1;
        for (int i = 0; i < rowIndex; ++i) {
            for (int j = rowIndex; j > 0; --j)
                num[j] += num[j - 1];
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int n : num)
            result.add(n);
        return result;
    }
}
