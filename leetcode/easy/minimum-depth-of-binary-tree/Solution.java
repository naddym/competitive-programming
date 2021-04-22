/**
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example 1:
    3    
   / \    
  9   20
     /  \
    15   7 
Input: root = [3,9,20,null,null,15,7]
Output: 2

Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 
Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000
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
    public int minDepth(TreeNode root) {  
        return minDepthBT(root);
    }
    
    private int minDepthBT(TreeNode root){
        if ( root == null)
            return 0;
        
        if (root.left == null && root.right != null) {
            return 1 + minDepthBT(root.right);
        } else if (root.left != null && root.right == null) {
            return 1 + minDepthBT(root.left);
        } 
        return 1 + Math.min(minDepthBT(root.left), minDepthBT(root.right));
    }
}