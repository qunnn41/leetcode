package answer;

public class NextPermutation {
	/**
	 * https://leetcode.com/problems/next-permutation/
	 */
	public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i > -1; --i) {
        	if (nums[i + 1] > nums[i]) {
        		int j = nums.length - 1;
        		while (j > i - 1 && nums[j] <= nums[i])
        			--j;
        		//swap
        		nums[i] ^= nums[j];
        		nums[j] ^= nums[i];
        		nums[i] ^= nums[j];
        		//reverse, since from (i + 1, nums.length - 1) is totally desecenting order
        		reverse(nums, i + 1, nums.length - 1);
        		return;
        	}
        }
        //reverse
        reverse(nums, 0, nums.length - 1);
    }
	
	private void reverse(int[] nums, int begin, int end) {
		int i = begin, j = end;
		while (i < j) {
			//swap
			nums[i] ^= nums[j];
			nums[j] ^= nums[i];
			nums[i] ^= nums[j];
			++i;
			--j;
		}
	}
}
