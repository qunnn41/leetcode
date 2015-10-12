package answer;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	/**
	 * https://leetcode.com/problems/expression-add-operators/
	 */
	List<String> result = new ArrayList<String>();
	public List<String> addOperators(String num, int target) {
		if (num == null || num.length() == 0)
			return result;
		helper("", num, target, 0, 0, 0);
		return result;
	}
	
	
	private void helper(String path, String num, int target ,int pos, long eval, long multed) {
		if (pos == num.length() - 1) {
			if (target == eval)
				result.add(path);
			return;
		}
		
		
		for (int i = pos; i < num.length(); ++i) {
			if (i != pos && num.charAt(i) == '0')
				break;
			long cur = Long.parseLong(num.substring(pos, i + 1));
			if (pos == 0) {
				helper(path + cur, num, target, i + 1, cur, cur);
			} else {
				helper(path + "+" + cur, num, target, i + 1, eval + cur, cur);
				helper(path + "-" + cur, num, target, i + 1, eval - cur, -cur);
				helper(path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
			}
		}
	}
}
