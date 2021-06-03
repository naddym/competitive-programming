/**
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

Example 3:

Input: s = "a"
Output: "a"

Example 4:

Input: s = "ac"
Output: "a"
 
Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),

*/

class Solution {
    public String longestPalindrome(String s) {
        String longest = new String();
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            int k = i;
            String odd = new String();
            while ( j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
            }
            
            odd = s.substring(j + 1, k);
            if (longest.length() < odd.length()) {
                longest = odd;
            }
            
            j = i;
            k = i + 1;
            String even = new String();
            while ( j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
            }
            
            even = s.substring(j + 1, k);
            if (longest.length() < even.length()) {
                longest = even;
            }
        }
        return longest;        
    }
}