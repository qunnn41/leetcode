package answer;

public class PowerOfFour {
    /**
     * https://leetcode.com/problems/power-of-four/
     */
    public boolean isPowerOfFour(int num) {
        if (num <= 0)
            return false;
        if (num == 1)
            return true;
        if (num < 3)
            return false;
        if (num % 4 != 0)
            return false;
        return isPowerOfFour(num / 4);
    }
}
