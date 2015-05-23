package answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
	/**
	 * https://leetcode.com/problems/3sum/
	 */
	public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < num.length - 2; ++i) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int l = i + 1, h = num.length - 1, sum = 0 - num[i];
                while (l < h) {
                    if (num[l] + num[h] == sum) {
                        result.add(Arrays.asList(num[i], num[l], num[h]));
                        while (l < h && num[l] == num[l + 1]) ++l;
                        while (l < h && num[h] == num[h - 1]) --h;
                        ++l;--h;
                    } else if (num[l] + num[h] < sum) {
                        ++l;
                    } else {
                        --h;
                    }
                }
            }
        }
        return result;
    }
}
