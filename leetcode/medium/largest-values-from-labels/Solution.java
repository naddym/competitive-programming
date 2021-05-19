/**
We have a set of items: the i-th item has value values[i] and label labels[i].

Then, we choose a subset S of these items, such that:

|S| <= num_wanted
For every label L, the number of items in S with label L is <= use_limit.
Return the largest possible sum of the subset S.

Example 1:

Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
Output: 9
Explanation: The subset chosen is the first, third, and fifth item.

Example 2:

Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
Output: 12
Explanation: The subset chosen is the first, second, and third item.

Example 3:

Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
Output: 16
Explanation: The subset chosen is the first and fourth item.

Example 4:

Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
Output: 24
Explanation: The subset chosen is the first, second, and fourth item.
 

Note:

1 <= values.length == labels.length <= 20000
0 <= values[i], labels[i] <= 20000
1 <= num_wanted, use_limit <= values.length

*/

class Solution {
    
    private static class Item {
        private final Integer value;
        private final Integer label;
        
        public Item(Integer val, Integer lab) {
            this.value = val;
            this.label = lab;
        }
        
        public Integer getValue() {
            return value;
        }
        
        public Integer getLabel() {
            return label;
        }
    }
    
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        
        PriorityQueue<Item> maxHeap = new PriorityQueue<>( (a, b) -> b.getValue() - a.getValue());       
        for(int i = 0; i < values.length; i++) {
            maxHeap.add(new Item(values[i], labels[i]));
        }
        
        int max = 0;
        Map<Integer, Integer> labelsMap = new HashMap<>();
        while (!maxHeap.isEmpty() && num_wanted > 0) {
            Item item = maxHeap.remove();
            
            int label = item.getLabel();
            if (labelsMap.getOrDefault(label, 0) == use_limit) {
                continue;
            }
            
            max += item.getValue();
            labelsMap.put(label, labelsMap.getOrDefault(label, 0) + 1);
        }
        
        return max;
    }
}