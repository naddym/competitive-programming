/**
--- LOGIC ---
Example :
Input: 0 8 1 6 0
Sorted Array :0 0 1 6 8
    for eg, take first element and last element
    0 + x = 8 - y
    x + y = 8 - 0 (i.e -> number of steps = nums[j] - nums[i])
*/
public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int i = 0, j = nums.length - 1, moves = 0;
        while (i < j) {
            moves += nums[j++] - nums[i++];
        }
        return moves;
    }
}