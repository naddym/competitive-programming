/**
Given a string s, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: s = "aab"
Output: "aba"

Example 2:

Input: s = "aaab"
Output: ""
Note:

s will consist of lowercase letters and have length in range [1, 500].

*/

class Solution {
    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        if (s == null || s.length() == 0) {
            return sb.toString();
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        
        while (maxHeap.size() > 1) {
            char x = maxHeap.remove();
            char y = maxHeap.remove();
            
            map.put(x, map.get(x) - 1);
            map.put(y, map.get(y) - 1);
            
            sb.append(x).append(y);
            
            if (map.get(x) > 0) {
                maxHeap.add(x);
            }
            if (map.get(y) > 0) {
                maxHeap.add(y);
            }
        }
        
        return maxHeap.isEmpty() ? sb.toString() : map.get(maxHeap.peek()) > 1 ? "" : sb.append(maxHeap.remove()).toString();
    }
}