package answer;

public class GasStation {
	/**
	 * https://leetcode.com/problems/gas-station/
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas.length == 0 || gas.length != cost.length)
			return -1;
		int i = 0, j = gas.length;
		int current = 0;
		int gasSum = 0;
		while (i != j) {
			gasSum += gas[current] - cost[current];
			if (gasSum >= 0) {
				++i;
				current = i;
			} else {
				--j;
				current = j;
			}
		}
		
		if (gasSum >= 0) {
			j = j % gas.length;
			return j;
		}
		return -1;
    }
}