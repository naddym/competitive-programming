/**
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 
Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // stack can also be used.
        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] previousInterval = list.peekLast();
            if (previousInterval[1] >= intervals[i][0]) {
                previousInterval[1] = Math.max(previousInterval[1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }
        }
        
        int[][] mergedIntervals = new int[list.size()][intervals[0].length];
        int i = 0;
        for (int[] interval: list) {
            mergedIntervals[i++] = interval;
        }
        
        return mergedIntervals;
    }
}