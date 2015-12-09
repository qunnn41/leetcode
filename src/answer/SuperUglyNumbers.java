package answer;

public class SuperUglyNumbers {
    /**
     * https://leetcode.com/problems/super-ugly-number/
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] location = new int[k];
        int[] nums = new int[n];
        nums[0] = 1;
        int a = 0;
        while (a < n - 1) {
            int index = Integer.MAX_VALUE;
            for (int i = 0; i < k; ++i) {
                if (nums[location[i]] * primes[i] < index) {
                    index = nums[location[i]] * primes[i];
                }
            }
            nums[++a] = index;
            for (int i = 0; i < k; ++i) {
                if (nums[location[i]] * primes[i] == index) {
                    location[i] ++;
                }
            }
        }
        return nums[n - 1];
    }
}
