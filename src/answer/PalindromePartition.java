package answer;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
	/**
	 * https://leetcode.com/problems/palindrome-partitioning/
	 */
	public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s.length() == 0)
            return null;
        if (s.length() == 1) {
        	List<String> temp = new ArrayList<String>();
        	temp.add(s);
        	result.add(temp);
        	return result;
        }
            
        for (int i = 1; i <= s.length(); i ++) {
            if (isPalindrome(s.substring(0, i))) {
                String begin = s.substring(0, i);
                List<List<String>> tempResult = partition(s.substring(i));
                if (tempResult != null) {
	                for (List<String> tempList : tempResult)
	                    tempList.add(0, begin);
	                for (List<String> tempList : tempResult)
	                    result.add(tempList);
                } else {
                    //i == s.length()
                	List<String> temp = new ArrayList<String>();
                	temp.add(begin);
                	result.add(temp);
                }
            }
        }
        return result;
    }
    
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i ++;
            j --;
        }
        return true;
    }
}
