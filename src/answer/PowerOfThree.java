package answer;

public class PowerOfThree {
    /**
     * https://leetcode.com/submissions/detail/50274560/
     */
    public boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        if (n == 2)
            return false;
        if (n % 3 != 0)
            return false;
        return isPowerOfThree(n / 3);
    }
}
