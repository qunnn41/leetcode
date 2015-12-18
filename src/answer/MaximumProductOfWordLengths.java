package answer;

public class MaximumProductOfWordLengths {
    /**
     * https://leetcode.com/problems/maximum-product-of-word-lengths/
     */
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2)
            return 0;
        int length = words.length;

        int[] letter = new int[length];
        for (int index = 0; index < length; ++index) {
            char[] array = words[index].toCharArray();
            for (char ch : array) {
                letter[index] |= 1 << (ch - 'a');
            }
        }

        int max = 0;
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                if ((letter[i] & letter[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
