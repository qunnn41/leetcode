package answer;

public class BullsAndCows {
	/**
	 * https://leetcode.com/problems/bulls-and-cows/
	 */
	public String getHint(String secret, String guess) {
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int one = 0, two = 0;
        int length = s.length;
        int[] count = new int[10];
        for (int i = 0; i < length; ++i) {
        	if (g[i] == s[i])
        		one ++;
        	else {
        		if (count[s[i] - '0'] < 0)
        			two ++;
        		if (count[g[i] - '0'] > 0)
        			two ++;
        		count[s[i] - '0'] ++;
        		count[g[i] - '0'] --;
        	}
        }
        return one + "A" + two + "B";
    }
}
