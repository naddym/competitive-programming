/**
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.

Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"

Example 2:

Input: s = "abcd", k = 2
Output: "bacd"
 
Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 104

*/

class Solution {
    public String reverseStr(String s, int k) {
        
        char[] ch = s.toCharArray();
        
        int i = 0;
        while (i < ch.length) {
           if ( ch.length - i > 2 * k || ch.length - i >= k ) {
                reverseSubstring(ch, i, i + k - 1);
           } else {
                reverseSubstring(ch, i, ch.length - 1);
           }
        
           i += 2 * k;
        }
        
        return String.valueOf(ch);
    }
    
    private void reverseSubstring(char[] ch, int i, int j){

        while (i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }
}