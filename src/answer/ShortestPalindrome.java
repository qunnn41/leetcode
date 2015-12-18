package answer;

public class ShortestPalindrome {
	/**
	 * https://leetcode.com/problems/shortest-palindrome/
	 */
	public String shortestPalindrome(String s) {
        char[] array = s.toCharArray();
        int max = 0;
        for (int i = array.length - 1; i > -1; --i) {
        	if (array[i] != array[0])
        		continue;
        	int high = i, low = 0;
        	while (high >= low && array[high] == array[low]) {
        		--high;
        		++low;
        	}
        	
        	if (high < low) {
        		max = i;
        		break;
        	}
        }
        
        //0-max is the shortest palindrome
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(max + 1));
        sb.reverse();
        sb.append(s);
        return sb.toString();
    }
}
