package answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	/**
	 * https://leetcode.com/problems/word-break-ii/
	 */
	public List<String> wordBreak(String s, Set<String> wordDict) {
        int n = s.length();

        List<List<String>> dp = new ArrayList<List<String>>();
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<String>());
        }
        dp.get(n).add("");

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j <= n; j++) {
                String word = s.substring(i, j);
                if (wordDict.contains(word)) {
                    for (String sentence : dp.get(j)) {
                        StringBuilder sb = new StringBuilder(word);
                        if (!sentence.isEmpty()) {
                            // append white space between words
                            sb.append(" ").append(sentence);
                        }
                        dp.get(i).add(sb.toString());
                    }
                }
            }
        }
        return dp.get(0);
    }
}
