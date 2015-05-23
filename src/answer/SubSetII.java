package answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubSetII {
	/**
	 * https://leetcode.com/problems/subsets-ii/
	 */
	public List<List<Integer>> subsetsWithDup(int[] num) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i ++)
            list.add(num[i]);
        Collections.sort(list);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int max = 1 << list.size();
        for (int i = 0; i < max; i ++) {
            List<Integer> temp = new ArrayList<Integer>();
            int k = i;
            int index = 0;
            int last = 0;
            boolean flag = true;
            
            while (k > 0) {
                if ((k & 1) > 0) {
                    if (index == 0) {
                        temp.add(list.get(0));
                        last = list.get(0);
                    } else {
                        if (list.get(index) == last && temp.size() > 0) {
                            flag = false;
                            break;
                        } else {
                            temp.add(list.get(index));
                            last = list.get(index);
                            for (int ii = index - 1; ii > - 1; ii --)
                                if (list.get(index) == list.get(ii))
                                    temp.add(list.get(ii));
                        }
                    }
                }
                k >>= 1;
                index ++;
            }
            
            if (flag)
                result.add(temp);
        }
        
        return result;
    }
}
