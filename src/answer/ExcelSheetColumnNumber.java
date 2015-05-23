package answer;

public class ExcelSheetColumnNumber {
	/**
	 * https://leetcode.com/problems/excel-sheet-column-number/
	 */
	public int titleToNumber(String s) {
        if (s.length() == 1)
			return s.charAt(0) - 'A' + 1;
        return titleToNumber(s.substring(0, s.length() - 1)) * 26 + titleToNumber(s.substring(s.length() - 1));
    }
}
