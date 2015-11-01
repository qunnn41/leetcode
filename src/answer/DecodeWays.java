package answer;

public class DecodeWays {
	/**
	 * https://leetcode.com/problems/decode-ways/
	 */
	public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int length = s.length();
        int[] count = new int[length + 1];
        count[length] = 1;
        count[length - 1] = s.charAt(length - 1) == '0' ? 0 : 1;
        
        for (int i = length - 2; i > -1; --i)
        	if (s.charAt(i) != '0')
        		count[i] = (Integer.parseInt(s.substring(i, i + 2)) < 27) ? count[i + 1] + count[i + 2] : count[i + 1];
        return count[0];	
    }
}
