package answer;

import java.util.HashSet;
import java.util.TreeMap;

public class RemoveDuplicateLetters {
    /**
     * https://leetcode.com/problems/remove-duplicate-letters/
     */
    public String removeDuplicateLetters(String s) {
        int[] c = new int[26];
        for (int i = 0; i < s.length(); ++i)
            c[s.charAt(i) - 'a'] ++;
        int pos = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) < s.charAt(pos))
                pos = i;
            if (-- c[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos).replace(s.charAt(pos) + "", ""));
    }
}
