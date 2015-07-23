package answer;

public class ReverseWordsInAString {
	/**
	 * https://leetcode.com/problems/reverse-words-in-a-string/
	 */
	public String reverseWords(String s) {
		if (s == null) {
			return null;
		}
		
		char[] array = s.toCharArray();
		int n = array.length;
		
		//reverse whole word
		reverse(array, 0, n - 1);
		
		//reverse words
		reverseWord(array, n);
		
		//cleanup space
		return cleanup(array, n);
    }
	
	//reverse ch[i] -- ch[j]
	private void reverse(char[] ch, int i, int j) {
		while (i < j) {
			char t = ch[i];
			ch[i] = ch[j];
			ch[j] = t;
			++i;--j;
		}
	}
	
	private String cleanup(char[] ch, int n) {
		int i = 0, j = 0;
		while (j < n) {
			while (j < n && ch[j] == ' ') j ++;
			while (j < n && ch[j] != ' ') ch[i ++] = ch[j ++];
			while (j < n && ch[j] == ' ') j ++;
			if (j < n) ch[i ++] = ' ';
		}
		
		return new String(ch).substring(0, i);
	}
	
	private void reverseWord(char[] ch, int n) {
		int i = 0, j = 0;
		while (i < n) {
			while (i < j || (i < n && ch[i] == ' ')) i++;
			while (j < i || (j < n && ch[j] != ' ')) j++;
			reverse(ch, i ,j - 1);
		}
	}
}
