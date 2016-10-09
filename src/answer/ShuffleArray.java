package answer;

import java.util.Random;

public class ShuffleArray {
    /**
     * https://leetcode.com/problems/shuffle-an-array/
     */
    class Solution {
        private int[] nums;
        private int[] copy;

        public Solution(int[] nums) {
            this.nums = nums;
            this.copy = nums.clone();
        }

        public int[] reset() {
            return copy;
        }

        // Fisher-Yates Shuffle
        public int[] shuffle() {
            Random random = new Random();
            for (int i = nums.length - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
            return nums;
        }
    }
}