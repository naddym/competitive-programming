/**
Given a string s, sort it in decreasing order based on the frequency of characters, and return the sorted string.

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 
Constraints:

1 <= s.length <= 5 * 105
s consists of English letters and digits.
*/

class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c: s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        final Map<Character, Integer> sortedFrequencyMap = frequencyMap.entrySet()
                .stream()
                .sorted((Map.Entry.<Character, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry: sortedFrequencyMap.entrySet()) {
            char c = entry.getKey();
            for (int i = 0 ; i < entry.getValue(); i++) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}