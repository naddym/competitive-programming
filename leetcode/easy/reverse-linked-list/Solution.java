/**
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:

1 -> 2 -> 3 -> 4 -> 5

5 -> 4 -> 3 -> 2 -> 1

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:

1 -> 2

2 -> 1

Input: head = [1,2]
Output: [2,1]

Example 3:

Input: head = []
Output: []
 
Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

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
    
    public ListNode reverseList(ListNode head) {
        if ( head == null || head.next == null) {
            return head;
        }
        
        Stack<Integer> stack = new Stack<>();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        
        ListNode reversed = new ListNode(stack.pop());
        
        ListNode temp = reversed;
        while(!stack.isEmpty()) {
            int val = stack.pop();
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        
        return reversed;
    }
}