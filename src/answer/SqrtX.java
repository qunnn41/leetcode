package answer;

public class SqrtX {
	/**
	 * https://leetcode.com/problems/sqrtx/
	 */
	public int sqrt(int x) {
        if (x == 0 || x == 1)
            return x;
            
        int low = 1, high = x / 2;

        while (high >= low) {
            int medium = (high + low) / 2;
            if (medium == x / medium)
                return medium;
            else if (medium > x / medium)
                high = medium - 1;
            else
                low = medium + 1;
        }
        
        return low - 1;
    }
}
