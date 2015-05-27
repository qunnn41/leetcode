package answer;


import java.util.LinkedList;
import java.util.List;

public class GenerateParenthese {
    /**
     * https://leetcode.com/problems/generate-parentheses/
     */
    LinkedList<String> result = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        helper("", n, 0);
        return result;
    }

    //left : n - '('
    //remain : '(' - ')'
    private void helper(String s, int left, int remain) {
        if (left == 0 && remain == 0) {
            result.add(s);
            return;
        }

        if (left > 0)
            helper(s + "(", left - 1, remain + 1);
        if (remain > 0)
            helper(s + ")", left, remain - 1);
    }
}
