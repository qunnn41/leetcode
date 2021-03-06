package answer;

public class CountAndSay {
	/**
	 * https://leetcode.com/problems/count-and-say/
	 */
	public String countAndSay(int n) {
        if (n <= 0) {return "";}
        String res = "1";
        for (int i = 1; i < n; i++) {
            String pre = res;
            res = "";
            char temp = pre.charAt(0);
            int count = 1;
            for (int j = 1; j < pre.length(); j++) {
                if (pre.charAt(j) != temp) {
                    res = res + count + temp;
                    temp = pre.charAt(j);
                    count = 1;
                } else {
                    count++;
                }
            }
            res = res + count + temp;
        }
        return res;
    }
}
