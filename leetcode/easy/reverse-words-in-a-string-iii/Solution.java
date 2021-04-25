/**
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:

Input: s = "God Ding"
Output: "doG gniD"
 
Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
*/

class Solution {
    public String reverseWords(String s) {
     
        String[] strArray = s.split(" ");
        for(int i = 0; i < strArray.length; i++) {
            strArray[i] = reverseString(strArray[i]);
        }
        
        return String.join(" ", strArray);
    }
    
    private String reverseString(String s){
        char[] ch = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = s.charAt(i);
            ch[i] = s.charAt(j);
            ch[j] = temp;
            i++;
            j--;
        }
        
        return String.valueOf(ch);
    }
}