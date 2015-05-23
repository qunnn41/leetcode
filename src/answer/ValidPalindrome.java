package answer;

public class ValidPalindrome {
	/**
	 * https://leetcode.com/problems/valid-palindrome/
	 */
	public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty())
        	return true;
        int h = 0, t = s.length() - 1;
        while (h < t) {
        	while (h <= t && !(Character.isLetter(s.charAt(h)) || Character.isDigit(s.charAt(h))))
        		++h;
        	if (h > t)
        		break;
        	char ch1 = Character.isLetter(s.charAt(h)) ? Character.toLowerCase(s.charAt(h)) : s.charAt(h);
        	while (h <= t && !(Character.isLetter(s.charAt(t)) || Character.isDigit(s.charAt(t))))
        		--t;
        	if (h > t)
        		break;
        	char ch2 = Character.isLetter(s.charAt(t)) ? Character.toLowerCase(s.charAt(t)) : s.charAt(t);
        	if (h == t) break;
        	if (ch1 == ch2) {
        		++h;
        		--t;
        	} else
        		return false;
        }
        return true;
    }
}
