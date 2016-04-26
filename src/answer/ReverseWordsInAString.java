package answer;

public class ReverseWordsInAString {
	/**
	 * https://leetcode.com/problems/reverse-words-in-a-string/
	 */
	// reverses the part of an array and returns the input array for convenience
	public void reverse(char[] arr, int i, int j) {
	    while (i < j) {
	        char tmp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = tmp;
	        i ++;
	        j --;
	    }
	}

	public String reverseWords(String s) {
		char[] str = s.toCharArray();
	    reverse(str, 0, s.length()-1);
	    int start = 0, end = 0;
	    for (int i = 0; i < str.length; i++) {
	        if (str[i] != ' ') {
	            str[end ++] = str[i];
	        } else if (i > 0 && str[i - 1] != ' ') {
	            reverse(str, start, end - 1);
	            str[end ++] = ' ';
	            start = end;
	        }
	    }
	    reverse(str, start, end - 1); 
	    return new String(str, 0, end).trim();
	}
}
