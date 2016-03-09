package answer;


public class MinimumWindowSubstring {
	/**
	 * https://leetcode.com/problems/minimum-window-substring/
	 */
	public String minWindow(String s, String t) {
		String result = "";
		int length_s = s.length();
		int length_t = t.length();
		if (length_t == 0) return result;
		int min = length_s + 1;
		int[] map = new int[256];
		int[] count = new int[256];
		
		for (int i = 0; i < length_t; ++i)
			map[t.charAt(i)] ++;
		int begin = 0, end = 0;
		int num = 0;
		while (end < length_s) {
			int current = s.charAt(end);
			if (++count[current] <= map[current])
				num ++;
			
			if (num == length_t) {
                //got one, cut redundant front part
				while (begin <= end) {
					int ch = s.charAt(begin);
					if (count[ch] > map[ch]) {
						count[ch] --; begin ++;
					} else break;
				}
				
                //find a smaller one
				if (min > end - begin + 1) {
					min = end - begin + 1;
					result = s.substring(begin, end + 1);
				}
			}
			end ++;
		}
		
		return result;
	}
}
