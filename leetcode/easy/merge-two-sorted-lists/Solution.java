/**
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

 

Example 1:

        1 --> 2 --> 4
        1 --> 3 --> 4
    1 --> 1 --> 2 --> 3 --> 4 --> 4
Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: l1 = [], l2 = []
Output: []

Example 3:

Input: l1 = [], l2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order  
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode mergeList = head; 
        while (l1 != null && l2 != null) {
            int val = l2.val;
            if (l1.val <= l2.val) {
                val = l1.val;
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
            head.next = new ListNode(val);
            head = head.next;
        }
        
        if (l1 != null) {
            head.next = l1;
        } else {
            head.next = l2;
        }
        
        return mergeList.next;
    }
}