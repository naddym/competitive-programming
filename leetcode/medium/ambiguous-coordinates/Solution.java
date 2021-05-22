/**
We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)". Then, we removed all commas, decimal points, and spaces and ended up with the string s.

For example, "(1, 3)" becomes s = "(13)" and "(2, 0.5)" becomes s = "(205)".
Return a list of strings representing all possibilities for what our original coordinates could have been.

Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other number that can be represented with fewer digits. Also, a decimal point within a number never occurs without at least one digit occurring before it, so we never started with numbers like ".1".

The final answer list can be returned in any order. All coordinates in the final answer have exactly one space between them (occurring after the comma.)

Example 1:

Input: s = "(123)"
Output: ["(1, 2.3)","(1, 23)","(1.2, 3)","(12, 3)"]

Example 2:

Input: s = "(0123)"
Output: ["(0, 1.23)","(0, 12.3)","(0, 123)","(0.1, 2.3)","(0.1, 23)","(0.12, 3)"]
Explanation: 0.0, 00, 0001 or 00.01 are not allowed.

Example 3:

Input: s = "(00011)"
Output: ["(0, 0.011)","(0.001, 1)"]
Example 4:

Input: s = "(100)"
Output: ["(10, 0)"]
Explanation: 1.0 is not allowed.
 
Constraints:

4 <= s.length <= 12
s[0] == '(' and s[s.length - 1] == ')'.
The rest of s are digits.

*/

class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        String str = s.substring(1, s.length() - 1);
        for (int i = 1; i < str.length(); i++) {
            String x = str.substring(0, i);
            String y = str.substring(i, str.length());
            result.addAll(allPossibilities(x, y));
        }
        
        return result;
    }
    
    private List<String> allPossibilities(String x, String y) {
        List<String> coordinates = new ArrayList<>();
        
        List<String> listX = new ArrayList<>();
        for (int i = 1; i < x.length(); i++) {
            String temp = x.substring(0, i) + "." + x.substring(i, x.length());
            if (isValid(temp)) {
                listX.add(temp);
            }
        }
                
        List<String> listY = new ArrayList<>();
        for (int i = 1; i < y.length(); i++) {
            String temp = y.substring(0, i) + "." + y.substring(i, y.length());
            if (isValid(temp)) {
                listY.add(temp);
            }
        }
        
        if (isValid(x)) {
           listX.add(x);   
        }
        
        if (isValid(y)) {
           listY.add(y);   
        }
        
        for (String strX: listX ) {
            for (String strY: listY) {
                coordinates.add("(" + strX + ", " + strY + ")");
            }
        }
        
        return coordinates;
    }
    
    private boolean isValid(String s) {
        if (s.startsWith("00") 
            || s.endsWith(".0") 
            || s.endsWith(".00") 
            || s.length() > 1 && s.startsWith("0") && s.charAt(1) != '.' 
            || s.length() > 1 && s.contains(".") && s.endsWith("0")) {
            return false;
        }
        return true;
    }
}