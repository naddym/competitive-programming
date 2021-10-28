class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int index = 1, ref = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (ref != nums[i]) {
                nums[index++] = nums[i];
                ref = nums[i];
            }
        }
        
        return index;
    }
}
