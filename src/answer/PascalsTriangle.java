package answer;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	/**
	 * https://leetcode.com/problems/pascals-triangle/
	 */
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return result;
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);result.add(list1);
        while (numRows > 1) {
            ArrayList<Integer> list2 = new ArrayList<Integer>();
            list2.add(1);
            for (int i = 0; i < list1.size() - 1; ++i)
                list2.add(list1.get(i) + list1.get(i + 1));
            list2.add(1);
            result.add(list2);
            list1 = list2;
            --numRows;
        }
        
        return result;
    }
}
