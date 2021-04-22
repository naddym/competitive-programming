/**
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
      1   
   /  |  \    
  2   |   2
 / \  |  / \
 4  3 | 4   3 

Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
    1    
   / \    
  2   2
  \    \
   3    3 

Input: root = [1,2,2,null,3,null,3]
Output: false
 
Constraints:

The number of nodes in the tree is in the range [1, 1000].
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        
        return isSymmetric(root, root);
    }
    
    private boolean isSymmetric(TreeNode root, TreeNode root1){
        if (root == null && root1 != null || root !=null && root1 ==null)
            return false;
        if (root == null && root1 == null)
            return true;
        
        if (root.val != root1.val)
            return false;
        
        return isSymmetric(root.left, root1.right) && isSymmetric(root.right, root1.left);
    }
}