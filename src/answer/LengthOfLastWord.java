package answer;

public class LengthOfLastWord {
	/**
	 * https://leetcode.com/problems/length-of-last-word/
	 */
	public int lengthOfLastWord(String s) {
		String[] str = s.split(" ");
        if (str.length == 0)
            return 0;
        return str[str.length - 1].length();
	}
}