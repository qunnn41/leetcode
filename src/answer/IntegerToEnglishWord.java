package answer;

public class IntegerToEnglishWord {
	/**
	 * https://leetcode.com/problems/integer-to-english-words/
	 */
	public String numberToWords(int num) {
        if (num == 0)
        	return "Zero";
        
        String[] big = {"", "Thousand", "Million", "Billion"};
        String[] small = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (num != 0) {
        	int cur = num % 1000;
        	int h = cur / 100;
        	int t = (cur / 10) % 10;
        	int o = cur % 10;
        	
        	StringBuilder temp = new StringBuilder();
        	if (h != 0) {
        		temp.append(ones[h] + " Hundred ");
        	}
        	
        	if (t == 1) {
        		temp.append(small[o] + " ");
        	} else {
        		if (t > 1)
        			temp.append(tens[t - 2] + " ");
        		if (o > 0)
        			temp.append(ones[o] + " ");
        	}
        	
        	if (temp.length() != 0)
        		temp.append(big[count] + " ");
        	
        	sb.insert(0, temp.toString());
        	num /= 1000;
        	count ++;
        }
        
        return sb.toString().trim();
    }
}
