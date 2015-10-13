package answer;

public class ValidAnagram {
	/**
	 * https://leetcode.com/problems/valid-anagram/
	 */
	public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
        	return false;
        
        int[] num = new int[26];
        char[] arrays = s.toCharArray();
        char[] arrayt = t.toCharArray();
        
        for (char ch : arrays) 
        	num[ch - 'a'] ++;
        
        for (char ch : arrayt)
        	num[ch - 'a'] --;
        
        for (int n : num)
        	if (n != 0)
        		return false;
        return true;
    }
}
