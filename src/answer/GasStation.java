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

    public int canCompleteCircuit2(int[] gas, int[] cost) {
	    int sumGas = 0;
	    int sumCost = 0;
	    int start = 0;
	    int tank = 0;
	    for (int i = 0; i < gas.length; i++) {
	        sumGas += gas[i];
	        sumCost += cost[i];
	        tank += gas[i] - cost[i];
	        if (tank < 0) {
	            start = i + 1;
	            tank = 0;
	        }
	    }
	    if (sumGas < sumCost) {
	        return -1;
	    } else {
	        return start;
	    }
	}
}