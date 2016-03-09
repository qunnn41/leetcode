package answer;

public class InterleavingString {
	/**
	 * https://leetcode.com/problems/interleaving-string/
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null) s1 = "";
		if (s2 == null) s2 = "";
		if (s3 == null) s3 = "";
		
        if (s3.length() != s2.length() + s1.length())
        	return false;

        //matrix[i][j] means s1(0,i) and s2(0,j) interleaves s3(0, i + j)
        boolean[][]matrix = new boolean[s2.length() + 1][s1.length() + 1];
        matrix[0][0] = true;
        
        for (int i = 1; i < matrix[0].length; ++i)
        	matrix[0][i] = matrix[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        
        for (int i = 1; i < matrix.length; ++i)
        	matrix[i][0] = matrix[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        
        for (int i = 1; i < matrix.length; ++i)
        	for (int j = 1; j < matrix[0].length; ++j)
        		matrix[i][j] = (matrix[i - 1][j] && (s2.charAt(i - 1) == s3.charAt(i + j - 1))) 
        			|| (matrix[i][j - 1] && (s1.charAt(j - 1) == s3.charAt(i + j - 1)));
        
        return matrix[s2.length()][s1.length()];
    }
}
