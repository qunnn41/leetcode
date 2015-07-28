package answer;

public class Candy {
	/**
	 * https://leetcode.com/problems/candy/
	 */

    public int candy(int[] ratings) {
    	int length = ratings.length;
    	if (length < 2)
    		return length;

    	int[] candy = new int[length];
    	for (int c = 0; c < length; ++c) {
    		candy[c] = 1;
    	}

    	for (int i = 1; i < length; ++i) {
    		if (ratings[i] > ratings[i - 1])
    			candy[i] = candy[i - 1] + 1;
    	}

    	for (int i = length - 1; i > 0; --i) {
    		if (ratings[i - 1] > ratings[i])
    			candy[i - 1] = Math.max(candy[i] + 1, candy[i - 1]);
    	}

    	int result = 0;
    	for (int c : candy)
    		result += c;
    	return result;
    }
}
