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

class BruteForceSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupByAnagrams = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return groupByAnagrams;
        }
        
        Map<String, Map<Character, Integer>> map = new HashMap<>();
        for (String s: strs) {
            Map<Character, Integer> frequencyMap = new HashMap<>();
            for (char c: s.toCharArray()){
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
            map.put(s, frequencyMap);
        }
        
        // need new instance of ArrayList to honor list.remove(anagram)
        List<String> anagrams = new ArrayList<>(Arrays.asList(strs));
        while (!anagrams.isEmpty()) {
            String anagram = anagrams.get(0);
            
            List<String> list = new ArrayList<>();
            list.add(anagram);
            
            Map<Character, Integer> frequencyMap = map.get(anagram);
            // Iterator is used to avoid ConcurrentModificationException
            Iterator<String> itr = anagrams.iterator();
            while (itr.hasNext()) {
                String key = itr.next();
                if (key != anagram && map.get(key).size() == frequencyMap.size()) {
                    boolean isAnagram = true;
                    for (Map.Entry<Character, Integer> entry: map.get(key).entrySet()) {
                        if (frequencyMap.get(entry.getKey()) != entry.getValue()) {
                            isAnagram = false;
                            break;
                        }
                    }
                    
                    if (isAnagram) {
                        // safely remove key from the list 
                        itr.remove();
                        list.add(key);
                    }
                }
            }

            groupByAnagrams.add(list);
            anagrams.remove(anagram);
        }
        
        return groupByAnagrams;
    }
}