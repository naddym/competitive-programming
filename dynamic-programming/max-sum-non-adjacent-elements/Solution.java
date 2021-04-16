/**
    Maximum Sum Non Adjacent Elements

    1. You are given a number n, representing the count of elements.
    2. You are given n numbers, representing n elements.
    3. You are required to find the maximum sum of a subsequence with no adjacent elements.

    Input
    A = [5, 10, 10, 100, 5, 6]

    Output
    Result = 116
*/

public class Solution {

    public int maxSumOfNonAdjacentElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int includeElement = arr[0];
        int excludeElement = 0;
        for (int i = 1; i < arr.length; i++) {
            int inc = excludeElement + arr[i];
            int exc = Math.max(includeElement, excludeElement);
            
            includeElement = inc;
            excludeElement = exc;
        }

        return Math.max(includeElement, excludeElement);
    }
}