/**
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]

Example 2:

Input: nums = [1,1]
Output: [1,2]
 
Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 104
*/

class Solution {
    public int[] findErrorNums(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        Arrays.sort(nums);
        
        int n = nums.length, duplicate = 0, sum = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] ==  nums[i - 1]) {
                duplicate = nums[i];
            }
            sum += nums[i];
        }
        
        int missingOffset = n * (n + 1) / 2 - sum; 
        
        return new int[]{duplicate, duplicate + missingOffset};     
    }
}