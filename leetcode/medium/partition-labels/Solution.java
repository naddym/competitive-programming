/**
A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 
Note:

S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.
*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> partitions = new ArrayList<>();
        if ( S == null || S.length() == 0) {
            return partitions;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i + 1);
        }
        
        int i = 0;
        while (i < S.length()) {
            char c = S.charAt(i);
            List<Character> charsSeen = new ArrayList<>();
            charsSeen.add(c);
            
            int j = i + 1;
            int k = map.get(c);
            while (j < k) {
                char next = S.charAt(j);
                if (!charsSeen.contains(next)) {
                    charsSeen.add(next);
                    k = Math.max(k, map.get(next));
                }
                j++;
            }
            
            partitions.add(k - i);
            i = k;
        }
    
        return partitions;
    }
}