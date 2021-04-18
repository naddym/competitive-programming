/**
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

Example 1:

Input: s = "hello"
Output: "holle"

Example 2:

Input: s = "leetcode"
Output: "leotcede"
 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */

class Solution {
    public String reverseVowels(String s) {
        
        int i = 0;
        int j = s.length() - 1;
        
        char[] characters = s.toCharArray();
        while (i < j) {
            if (isVowel(characters[i]) && isVowel(characters[j])) {
                char temp = characters[i];
                characters[i] = characters[j];
                characters[j] = temp;
                j--;
                i++;
            } else if (!isVowel(characters[j])) {
                j--;
            } else {
                i++;
            }
        }
        
        return new String(characters);
    }
    
    private boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' 
            || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }
        
        return false;
    }
}