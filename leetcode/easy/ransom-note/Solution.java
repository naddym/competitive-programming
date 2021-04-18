/**
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints: 
You may assume that both strings contain only lowercase letters.
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null) {
            return false;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()) {
            map.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        
        for(char c : ransomNote.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        
        return true;
    }
}