/**
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]

Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 
Constraints:

1 <= s.length <= 105
s[i] is either 'A', 'C', 'G', or 'T'.

*/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        final List<String> repeatedSequences = new ArrayList<>();
        final Map<String, Integer> substrings = new HashMap<>();
        
        int i = 0;
        while (i + 10 <= s.length()) {
            final String sequence = s.substring(i, i + 10);
            substrings.put(sequence, substrings.getOrDefault(sequence, 0) + 1);
            if (substrings.get(sequence) == 2) {
                repeatedSequences.add(sequence);  
            }
            i++;
        }
        
        return repeatedSequences;
    }
}