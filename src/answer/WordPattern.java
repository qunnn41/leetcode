package answer;

import java.util.HashMap;

public class WordPattern {
	/**
	 * https://leetcode.com/problems/word-pattern/
	 */
	public boolean wordPattern(String pattern, String str) {
        char[] p = pattern.toCharArray();
        String[] s = str.split(" ");
        
        HashMap<Character, String> map1 = new HashMap<Character, String>();
        HashMap<String, Character> map2 = new HashMap<String, Character>();
        
        if (p.length != s.length)
        	return false;
        
        for (int i = 0; i < p.length; ++i) {
        	char ch = p[i];
        	String string = s[i];
        	
        	if (map1.containsKey(ch)) {
        		if (!map1.get(ch).equals(string))
        			return false;
        	} else if (map2.containsKey(string)) {
        		if (map2.get(string) != ch)
        			return false;
        	} else {
        		map1.put(ch, string);
        		map2.put(string, ch);
        	}
        }
        
        return true;
    }
}
