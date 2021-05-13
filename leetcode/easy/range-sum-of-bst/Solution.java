/**
Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].

 
Example 1:
     10
    / \
   5   15
  / \   \
 3   7   18
Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32

Example 2:
      10
     /  \
    5    15
   / \   / \
  3   7 13  18
 /   /
3    6
Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
 
Constraints:

The number of nodes in the tree is in the range [1, 2 * 104].
1 <= Node.val <= 105
1 <= low <= high <= 105
All Node.val are unique.

 */

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (current.val >= low && current.val <= high) {
                sum += current.val;
            }
            
            if (current.left != null && current.val > low) {
                queue.add(current.left);
            }
            if (current.right != null && current.val < high) {
                queue.add(current.right);
            }
        }
        
        return sum;
    }   
}