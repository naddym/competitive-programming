/**
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 
Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        if (nums.length == 0) {
            return range;
        }

        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + ((j - i) / 2);
            if (nums[mid] == target) {
                
                for (int k = mid; k >= 0; k--) {
                    if (nums[k] == target) {
                        range[0] = k;
                    } else {
                        break;
                    }
                }
                
                for (int k = mid; k < nums.length; k++) {
                    if (nums[k] == target) {
                        range[1] = k;
                    } else {
                        break;
                    }
                }
                
                return range;
            }
            
            if (target < nums[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        
        return range;
    }
}