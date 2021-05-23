/**
Let's say a positive integer is a super-palindrome if it is a palindrome, and it is also the square of a palindrome.

Given two positive integers left and right represented as strings, return the number of super-palindromes integers in the inclusive range [left, right].

Example 1:

Input: left = "4", right = "1000"
Output: 4
Explanation: 4, 9, 121, and 484 are superpalindromes.
Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
Example 2:

Input: left = "1", right = "2"
Output: 1
 
Constraints:

1 <= left.length, right.length <= 18
left and right consist of only digits.
left and right cannot have leading zeros.
left and right represent integers in the range [1, 1018 - 1].
left is less than or equal to right.

*/

class Solution {
    public int superpalindromesInRange(String left, String right) {
        long lft = Long.valueOf(left);
        long rht = Long.valueOf(right);
        int superPalindromes = 0;
        
        // create te palindrome in range 1, 100000
        
        // even palindromes
        for (int i = 1; i < 1_00_00_0; i++) {
            StringBuilder sb = new StringBuilder(Integer.toString(i));
            for (int j = sb.length() - 1; j >= 0; j--) {
                sb.append(sb.charAt(j));
            }
            
            long n = Long.valueOf(sb.toString());
            n = n * n;
            // Check if n is a super palindrome
            if (n > rht) {
                break;
            } else if (n >= lft && n <= rht && isPalindrome(n)) {
                superPalindromes++;
            }
        }
        
        // odd palindrome
        for (int i = 1; i < 1_00_00_0; i++) {
            StringBuilder sb = new StringBuilder(Integer.toString(i));
            for (int j = sb.length() - 2; j >= 0; j--) {
                sb.append(sb.charAt(j));
            }
            
            long n = Long.valueOf(sb.toString());
            n = n * n;
            // Check if n is a super palindrome
            if (n > rht) {
                break;
            } else if (n >= lft && n <= rht && isPalindrome(n)) {
                superPalindromes++;
            }
        }
        
        return superPalindromes;
    }
    
    private boolean isPalindrome(long n) {
        return n == reverse(n);
    }
    
    private long reverse(long n) {
        long rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n = n / 10;
        }
        return rev;
    }
}