/**
Count the number of prime numbers less than a non-negative number, n.

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
 

Constraints:

0 <= n <= 5 * 106

*/

class Solution {
    public int countPrimes(int n) {
        // sieve of eratosthenes algorithm
        boolean[] primes = new boolean[n];
        
        for (int i = 2; i < n; i++) {
            if (!primes[i]) {
                int j = 2;
                while (i * j < n) {
                    primes[i * j] = true;
                    j++;
                }
            }
        }
        
        int countPrimes = 0;
        for (int i = 2; i < n; i++) {
            if (!primes[i]) {
                countPrimes++;
            }
        }
        
        return countPrimes;
    }
}
