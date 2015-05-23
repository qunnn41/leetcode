package answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubSet {
	/**
	 * https://leetcode.com/problems/subsets/
	 */
	public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int max = 1 << S.length;
        for (int i = 0; i < max;i ++) {
            List<Integer> temp = new ArrayList<Integer>();
            int k = i;
            int index = 0;
            while (k > 0) {
                if ((k & 1) > 0) {
                    temp.add(S[index]);
                }
                k >>= 1;
                index ++;
            }//end while
            Collections.sort(temp);
            result.add(temp);
        }//end for
        return result;
    }
}
