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
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : (i - 1 - stack.peek());
                //System.out.println(i + "\t" + h + "\t" + w + "\n");
                int rect = h * w;
                maxRect = Math.max(maxRect, rect);
            }
            stack.push(i);
        }
        return maxRect;
    }
}
