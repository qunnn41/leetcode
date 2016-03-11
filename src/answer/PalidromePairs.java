package answer;

import java.util.*;

public class PalidromePairs {
    /**
     * https://leetcode.com/problems/palindrome-pairs/
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        Map<String, Integer> index = new HashMap<String, Integer>(n);
        Map<String, Integer> revIndex = new HashMap<String, Integer>(n);
        String[] revWords = new String[n];
        for (int i = 0; i < n; ++i) {
            String s = words[i];
            String r = new StringBuilder(s).reverse().toString();
            index.put(s, i);
            revIndex.put(r, i);
            revWords[i] = r;
        }

        List<List<Integer>> result = new ArrayList<>();
        result.addAll(findPairs(words, revWords, revIndex, false));
        result.addAll(findPairs(revWords, words, index, true));
        return result;
    }

    private List<List<Integer>> findPairs(String[] words, String[] revWords,
                                          Map<String, Integer> revIndex, boolean reverse) {
        List<List<Integer>> result = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; ++i) {
            String s = words[i];
            for (int k = reverse ? 1 : 0; k <= s.length(); ++k) {
                Integer j = revIndex.get(s.substring(k));
                if (j != null && j != i) {
                    if (s.regionMatches(0, revWords[i], s.length() - k, k)) {
                        result.add(reverse ? Arrays.asList(i, j) : Arrays.asList(j, i));
                    }
                }
            }
        }
        return result;
    }
}
