package answer;

public class RectangleArea {
	/**
	 * https://leetcode.com/problems/rectangle-area/
	 */
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        int A1 = Math.max(A, E);
        int B1 = Math.min(B, F);
        int D1 = Math.min(D, H);
        int C1 = Math.max(C, G);
        
        if (A1 >= C1 || B1 >= D1)
        	return area;

        return area - (D1 - B1) * (C1 - A1);
    }
}
