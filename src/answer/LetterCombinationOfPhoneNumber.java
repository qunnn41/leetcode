package answer;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {
	/**
	 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
	 */
	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0 || digits == "")
			return new ArrayList<String>();
        String[] digit = new String[] {"", "", "abc", "def",
        		"ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        char[] ch = digits.toCharArray();
        List<String> result = new ArrayList<String>();
        result.add("");
        for (char c : ch) {
        	int index = c - '0';
        	List<String> current = new ArrayList<String>();
        	for (int j = 0; j < digit[index].length(); ++j) {
        		char d = digit[index].charAt(j);
        		for (int i = 0; i < result.size(); ++i) {
        			current.add(result.get(i) + d);
        		}
        	}
        	result.clear();
        	result.addAll(current);
        }

        if (result.size() > 1)
        	result.remove("");
        return result;
    }
}
