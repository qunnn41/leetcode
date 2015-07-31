package answer;

public class MultiplyString {
	/**
	 * https://leetcode.com/problems/multiply-strings/
	 */
	public String multiply(String num1, String num2) {
		char[] array1 = num1.toCharArray();
		char[] array2 = num2.toCharArray();
		int n1 = array1.length;//1234
		int n2 = array2.length;//56
		int[][] products = new int[n2][n1 + n2];
		
		for (int i = 0; i < n2; ++i) {
			int count = (n2 - 1) - i;
			for (int j = n1 + n2 - 1; j >= n2; --j) {
				products[i][j - count] = (array2[i] - '0') * (array1[j - n2] - '0');
			}
			int carry = 0;
			for (int j = n1 + n2 - 1; j > -1; --j) {
				products[i][j] += carry;
				carry = products[i][j] / 10;
				products[i][j] %= 10;
			}
		}
		
		int[] result = new int[n1 + n2];
		int carry = 0;
		char[] ch = new char[n1 + n2];
		for (int i = n1 + n2 - 1; i > -1; --i) {
			for (int j = 0; j < n2; ++j) {
				result[i] += products[j][i];
			}
			result[i] += carry;
			carry = result[i] / 10;
			result[i] %= 10;
			ch[i] = (char) (result[i] + '0');
		}
		
		int i = 0;
		while (i < ch.length && ch[i] == '0')
			++i;
		String str = "";
		for (int j = i; j < ch.length; ++j)
			str += ch[j] + "";
		return (str == "") ? "0" : str;
    }
}
