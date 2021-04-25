class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSubArray = 0D;
        if (nums == null || nums.length == 0) {
            return maxSubArray;
        } 
        
        for (int i = 0; i < k; i++) {
            maxSubArray += Double.valueOf(nums[i]);
        }
        
        int offsetIndex = 0;
        double currentSum  = maxSubArray;
        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum + nums[i] - nums[offsetIndex++];
            maxSubArray = Math.max(maxSubArray, currentSum); 
        }
        
        return maxSubArray / k;
    }
}