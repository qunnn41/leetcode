package answer;

public class MajorityElements {
	/**
	 * https://leetcode.com/problems/majority-element/
	 */
	public int majorityElement(int[] num) {
        int count = 0;
        int major = -1;
        for (int i = 0; i < num.length; i ++) {
            if (count == 0) {
                major = num[i];
                count ++;
            } else {
                if (num[i] == major) {
                    count ++;
                } else {
                    count --;
                }
            }
        }
        return major;
    }
}
