/**
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:
    3    
   / \    
  9   20
     /  \
    15   7 

Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:

Input: root = [1,null,2]
Output: 2

Example 3:

Input: root = []
Output: 0

Example 4:

Input: root = [0]
Output: 1
 
Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100

 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if ( root == null)
            return 0;
        
        return maxDepthBT(root);
    }
    
    private int maxDepthBT(TreeNode root){
        if (root == null)
            return 0;        
        return 1 + Math.max(maxDepthBT(root.left), maxDepthBT(root.right));
    }
}