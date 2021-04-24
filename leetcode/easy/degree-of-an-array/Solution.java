/**
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:

Input: nums = [1,2,2,3,1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.

Example 2:

Input: nums = [1,2,2,3,1,4,2]
Output: 6
Explanation: 
The degree is 3 because the element 2 is repeated 3 times.
So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 
Constraints:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.

*/

class Solution {
    public int findShortestSubArray(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
             map.compute(nums[i], (k, v) -> v == null ? 1 : v + 1);
        }
        
        int max = Collections.max(map.values());
        
        List<Integer> duplicateOccurences = new ArrayList();
        for (Map.Entry<Integer, Integer> es: map.entrySet()) {
            if (es.getValue() == max) {
                duplicateOccurences.add(es.getKey());
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < duplicateOccurences.size(); j++) {
            int element = duplicateOccurences.get(j); 
            
            int start = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == element) {
                    start = i;
                    break;
                }
            }

            int end = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == element) {
                    end = i;
                    break;
                }
            }    
            
            min = Math.min(min, end - start + 1);
        }
        
        return min;
    }
}