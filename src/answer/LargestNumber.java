package answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
	/**
	 * https://leetcode.com/problems/largest-number/
	 */
	public String largestNumber(int[] num) {
        List<String> number = new ArrayList<String>();
        for (int i = 0; i < num.length; i ++)
            number.add(num[i] + "");
            
        Collections.sort(number, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				String s1s2 = s1 + s2;
				String s2s1 = s2 + s1;
				return s2s1.compareTo(s1s2);
			}
		});
		
		String result = "";
		for (int i = 0; i < number.size(); i ++)
		    result += number.get(i);
		    
		if (result.charAt(0) == '0')
		    return "0";
		
		return result;
    }
}
