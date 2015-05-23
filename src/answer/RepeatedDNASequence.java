package answer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class RepeatedDNASequence {
	/**
	 * https://leetcode.com/problems/repeated-dna-sequences/
	 */
	public List<String> findRepeatedDnaSequences(String s) {
        HashSet<Integer> hash = new HashSet<Integer>();
        LinkedList<String> result = new LinkedList<String>();
        if (s.length() < 11)
            return result;
        for (int i = 0; i < s.length() - 9; ++i) {
            String str = s.substring(i, i + 10);
            if (!hash.contains(hashcode(str))) {
                hash.add(hashcode(str));
            } else {
                if (!result.contains(str))
                    result.add(str);
            }
        }
        
        return result;
    }
    
    private int hashcode(String s) {
        int result = 0;
        for (int i = 0; i < 10; ++i) {
            char ch = s.charAt(i);
            if (ch == 'A')
                result = 1 + result * 4;
            else if (ch == 'T')
                result = 2 + result * 4;
            else if (ch == 'G')
                result = 3 + result * 4;
            else
                result *= 4;
        }
        
        return result;
    }
}
