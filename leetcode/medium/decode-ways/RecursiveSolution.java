/**
    A message containing letters from A-Z can be encoded into numbers using the following mapping:

    'A' -> "1"
    'B' -> "2"
    ...
    'Z' -> "26"
    To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

    "AAJF" with the grouping (1 1 10 6)
    "KJF" with the grouping (11 10 6)
    Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

    Given a string s containing only digits, return the number of ways to decode it.

    The answer is guaranteed to fit in a 32-bit integer.

    Example 1:
    Input: s = "12"
    Output: 2
    Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

    Example 2:
    Input: s = "226"
    Output: 3
    Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

    Example 3:
    Input: s = "0"
    Output: 0
    Explanation: There is no character that is mapped to a number starting with 0.
    The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
    Hence, there are no valid ways to decode this since all digits need to be mapped.

    Example 4:
    Input: s = "06"
    Output: 0
    Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 */

public class RecursiveSolution {

    public int numDecodings(String s) {
        return decodeWays(s);
    }

    private int decodeWays(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return isValid(s) ? 1 : 0;
        } else if (len == 2) {
            int ways = 0;
            if (isValid(s)) {
                ways += 1;   
            }
            if (isValid(s.substring(len - 1, len))) {
                ways += decodeWays(s.substring(0, len - 1));
            }
            return ways;
        }
        
        int ways = 0;
        if (isValid(s.substring(len - 1, len))) {
            ways += decodeWays(s.substring(0, len - 1));
        }    
        if (isValid(s.substring(len - 2, len))) {
            ways += decodeWays(s.substring(0, len - 2));
        }
        return ways;
    }
    
    private boolean isValid(String s) {
        int len = s.length();
        if (len == 0 ) {
            return false;
        } else if (len == 1) {
            return Integer.parseInt(s) > 1 && Integer.parseInt(s) < 10;
        } else {
            return Integer.parseInt(s) > 9 && Integer.parseInt(s) < 27;            
        }
    }
}