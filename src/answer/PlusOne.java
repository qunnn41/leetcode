package answer;

public class PlusOne {
	/**
	 * https://leetcode.com/problems/plus-one/
	 */
	public int[] plusOne(int[] digits) {
        boolean flag = true;
        for (int i = 0; i < digits.length; i ++)
            if (digits[i] != 9) {
                flag = false;
                break;
            }
        if (flag) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        
        int index = digits.length - 1;
        int[] result = new int[digits.length];
        while (digits[index] == 9) {
            result[index] = 0;
            index --;
        }
        result[index] = digits[index] + 1;
        index --;
        while (index >= 0) {
            result[index] = digits[index];
            index --;
        }
        return result;
    }
}
