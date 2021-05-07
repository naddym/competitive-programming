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
        }
        
        Stack<Character> stack = new Stack<>();
        
        for (char c: num.toCharArray()) {            
            while (!stack.isEmpty() && k > 0 && (stack.peek() - '0') > ( c - '0')) {
                stack.pop();
                k--;
            }

            if (!(stack.isEmpty() && c == '0')) {
                stack.push(c); 
            }
        }
        
        while (k != 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        if (stack.isEmpty()) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}