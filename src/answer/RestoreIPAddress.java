package answer;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
	/**
	 * https://leetcode.com/problems/restore-ip-addresses/
	 */
	public List<String> restoreIpAddresses(String s) {
        List<String> result = getIP(s, 4);
        if (result == null)
            result = new ArrayList<String>();
        return result;
    }
    
    private List<String> getIP(String s, int length) {
        if (length <= 0 || s.length() == 0 || s == null)
            return null;
            
        List<String> result = new ArrayList<String>();
        if (length == 1) {
            if (isIP(s)) {
                result.add(s);
                return result;
            } else {
                return null;
            }
        }
        
        int min = s.length() > 4 ? 4 : s.length();

        for (int i = 1; i < min; i ++) {
            if (isIP(s.substring(0, i))) {
                List<String> temp = getIP(s.substring(i), length - 1);
                if (temp != null) {
                    for (String ss : temp)
                        result.add(s.substring(0, i) + "." + ss);
                }
            }
        }
        return result;
    }
    
    private boolean isIP(String s) {
        if (s.length() > 3)
            return false;
        if (s.length() > 1 && s.charAt(0) == '0')
            return false;
        int number = Integer.parseInt(s);
        return number >=0 && number <= 255;
    }
}
