package answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
	/**
	 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
	 */
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (words.length == 0 || words[0].isEmpty() || words[0].length() > s.length())
        	return result;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String w : words)
        	map.put(w, !map.containsKey(w) ? 1 : map.get(w) + 1);
        int size = words[0].length();
        for (int i = 0; i <= s.length() - size * words.length; ++i) {
        	HashMap<String, Integer> map2 = new HashMap<String, Integer>(map);
        	for (int j = 0; j < words.length; ++j) {
        		String str = s.substring(i + j * size, i + j * size + size);
        		if (map2.containsKey(str)) {
        			int count = map2.get(str);
        			if (count == 1) map2.remove(str);
        			else map2.put(str, count - 1);
        			if (map2.isEmpty()) {
        				result.add(i);
        				break;
        			}
        		} else break;
        	}
        }
        
        return result;
    }
}
