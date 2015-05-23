package answer;

public class LongestCommonPrefix {
	/**
	 * https://leetcode.com/problems/longest-common-prefix/
	 */
	public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String result = strs[0];
        int i = 1;
        while (i < strs.length) {
            if (strs[i].startsWith(result))
                ++i;
            else
                result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = new String[] {"aa","ab"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
