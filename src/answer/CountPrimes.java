package answer;

public class CountPrimes {
	/**
	 * https://leetcode.com/problems/count-primes/
	 */
	public int countPrimes(int n) {
		int count = 0;
        boolean[] prime = new boolean[n];
        for (int i = 2; i < n; ++i) {
        	if (prime[i] == false) {
        		//is prime
        		count ++;
        		for (int j = 2 * i; j < n; j += i) {
        			prime[j] = true;
        		}
        	}
        }
        
        return count;
    }
}
