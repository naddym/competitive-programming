/**
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:

Input: strs = ["a"]
Output: [["a"]]
 
Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lower-case English letters.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, List> anagramsMap = new HashMap<>();
        for (String s: strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if (!anagramsMap.containsKey(key)) {
                anagramsMap.put(key, new ArrayList<>());
            }
            anagramsMap.get(key).add(s);
        }
          
        return new ArrayList(anagramsMap.values());
    }
}