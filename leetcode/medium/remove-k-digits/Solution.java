/**
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 
Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.

*/
class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || k == 0) {
            return num;
        } else if (num.length() <= k) {
            return "0";
        }
        
        int digits = num.length() - k;
        char[] ch = num.toCharArray();
        int t = -1, start = 0;
        
        for (int i = 0; i < ch.length; i++) {
            while (t >= 0 && ch[t] > ch[i] && k > 0) {
                t--;
                k--;
            }
            t++;
            ch[t] = ch[i];
        }
        
        while (start <= t && ch[start] == '0') {
            start++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = start; i < digits; i++) {
            sb.append(ch[i]);
        }
        
        return sb.toString().isEmpty() ? "0" : sb.toString();
    }
}