class Solution {
    public int rob(int[] nums) {
        int[][] memo = new int[nums.length][2];
        
        int robYes = rob(nums, 0, Rob.YES, memo);
        int robNo = rob(nums, 0, Rob.NO, memo);
        return Math.max(robYes, robNo);
    }
    
    private int rob(int[] nums, int i, Rob rob, int[][] memo) {
        if (i >= nums.length) {
            return 0;
        }
        
        int typeIndex = Rob.valueOf(rob.name()).ordinal();
        if (memo[i][typeIndex] > 0) {
            return memo[i][typeIndex];
        }
        int money = 0;
        if (rob == Rob.YES) {
            int robYes = nums[i] + rob(nums, i + 1, Rob.NO, memo);
            int robNo = rob(nums, i + 1, Rob.YES, memo);
            money = Math.max(robYes, robNo);
        } else {
            int robNo = rob(nums, i + 1, Rob.YES, memo);
            int robYes = rob(nums, i + 1, Rob.NO, memo);
            money = Math.max(robNo, robYes);
        }
        
        memo[i][typeIndex] = money;
        return money;
    }
    
    private enum Rob {
        YES,NO
    }
}
