/**
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:

Input: nums = [0]
Output: [[],[0]]
 
Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.

*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {        
        List<List<Integer>> subsets = findSubsets(nums, 0);
        // empty array is also a valid subsets;
        subsets.add(new ArrayList<>());
        return subsets;
    }
    
    private List<List<Integer>> findSubsets(int[] nums, int j) {
        List<List<Integer>> subsets = new ArrayList<>();
        
        if (j >= nums.length) {
            return subsets;
        }
        
        for (int i = j; i < nums.length; i++) {
            List<Integer> currentNum = new ArrayList<>();
            currentNum.add(nums[i]);
            subsets.add(currentNum);

            List<List<Integer>> othersNums = findSubsets(nums, i + 1);
            if (!othersNums.isEmpty()) {
                for (List<Integer> otherNum: othersNums ) {
                    otherNum.add(nums[i]);
                    subsets.add(otherNum);
                }   
            }
        }
        
        return subsets;
    }
}