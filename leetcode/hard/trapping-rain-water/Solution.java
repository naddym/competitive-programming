/**
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 
Constraints:

n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105

*/

class Solution {
    public int trap(int[] height) {
        int N = height.length;
        int[] leftMax = new int[N];
        int[] rightMax = new int[N];
        int water = 0;
        
        for (int i = 0; i < N; i++ ) {
            if (i == 0) {
                leftMax[i] = height[i];
                rightMax[N - i - 1] = height[N - i - 1];
            } else {
                leftMax[i] = Math.max(height[i], leftMax[i - 1]);
                rightMax[N - i - 1] = Math.max(height[N - i - 1], rightMax[N - i]);
            }
        }
        
        for (int i = 0; i < N; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        
        return water;
    }
}