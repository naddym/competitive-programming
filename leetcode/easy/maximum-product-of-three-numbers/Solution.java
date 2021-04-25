/**
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6
 
Constraints:

3 <= nums.length <= 104
-1000 <= nums[i] <= 1000

*/
class Solution {
    public int maximumProduct(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        
        int negCount = 0 ;
        for (int i = 0; negCount <= 1 && i < n; i++) {
            if (nums[i] < 0) {
                negCount++;
            }
        }
        
        int maxProduct = nums[n - 1] * nums[n - 2] * nums[n - 3];
        if (negCount == 2) {
            maxProduct = Math.max(maxProduct, nums[0] * nums[1] * nums[n - 1]);
        }
        
        return maxProduct;   
    }
}