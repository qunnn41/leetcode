package answer;

public class AddBinary {
	/**
	 * https://leetcode.com/problems/add-binary/
	 */
	public String addBinary(String a, String b) {
		int a_len = a.length();
        int b_len = b.length();
        String p = (a_len >= b_len) ? a : b;
        String q = p.equals(a) ? b : a;
        
        //p point to the larger one
        String str = "";
        int c = 0;
        a_len = p.length();
        b_len = q.length();
        int i = a_len - 1;
        for (; i > a_len - b_len - 1; --i) {
        	int r = (p.charAt(i) - '0') + (q.charAt(i - (a_len - b_len)) - '0') + c;
        	c = (r >= 2) ? 1 : 0;
        	r %= 2;
        	str = r + "" + str;
        }
        
        for (i = a_len - b_len - 1; i > -1; --i) {
        	int r = (p.charAt(i) - '0') + c;
        	c = (r >= 2) ? 1 : 0;
        	r %= 2;
        	str = r + "" + str;
        }
        
        if (c == 1)
        	str = "1" + str;
        return str;
    }
}
