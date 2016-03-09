package answer;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
	/**
	 * https://leetcode.com/problems/largest-rectangle-in-histogram/
	 */
	public int largestRectangleArea(int[] height) {
		//add zero at the end
        height = Arrays.copyOf(height, height.length + 1);

        int maxRect = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < height.length; ++i) {
            while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                int rect = height[stack.pop()] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                System.out.println(i + "\t" + rect + "\t" + (stack.isEmpty() ? i : (i - stack.peek() - 1)));
                maxRect = Math.max(maxRect, rect);
            }
            stack.push(i);
        }

        return maxRect;
    }

    public static void main(String[] args) {
        new LargestRectangleInHistogram().largestRectangleArea(new int[] {2,1,5,6,2,3});
    }
}
