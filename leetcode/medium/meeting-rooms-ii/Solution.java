/**
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:
Input:  [[0, 30],[5, 10],[15, 20]],
Output: 2.

Example 2:
Input: [[7, 10], [2, 4]]
Output: 1

*/

/**
* Definition for an interval
* public class Interval {
*    int start;
*    int end;
*    Interval() { start = 0; end = 0; }
*    Interval(int s, int e) { start = s; end = e; }
* }  
*/
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> (a.end - b.end));
        minHeap.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval current= intervals[i];

            if (minHeap.peek().end <= current.start) {
                minHeap.remove();
            }

            minHeap.add(current);
        }

        return minHeap.size();
    }
}