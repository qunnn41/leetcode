package answer;

public class ZigzanConversation {
	/**
	 * https://leetcode.com/problems/zigzag-conversion/
	 */
	public String convert(String s, int numRows) {
		if (numRows == 1) return s;
        String[] str = new String[numRows];
        String result = "";
        
        for (int i = 0; i < numRows; ++i)
        	str[i] = "";
        
        int index = 0;
        int step = 1;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; ++i) {
        	str[index] += array[i];
        	index += step;
        	
        	if (index == numRows - 1)
        		step = -1;
        	if (index == 0)
        		step = 1;
        }
        
        for (String g : str) 
        	result += g;
        
        return result;
    }
}
