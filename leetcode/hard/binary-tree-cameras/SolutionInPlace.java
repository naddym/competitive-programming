/**
Given a binary tree, we install cameras on the node of the tree.

Each camera at a node can monitor its parent, itself, and its immediate children.

Calculate the minimum number of cameras needed to monitor all nodes of the tree.

Example 1:
        0
       / 
      [camera]
    /  \
   0    0  
Input: [0, 0, null, 0, 0]
Output: 1
Explanation: One camera is enough to monitor all nodes if places as shown

Example 2:
        0
       /
      [camera]
     /
    0
   /    
  [camera]
  \
   0
Input: root = [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.
 
Constraints:

The number of nodes in the tree is in the range [1, 1000].
Node.val == 0

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
    int cameras = 0;
    
    public int minCameraCover(TreeNode root) {
        return dfs(root) == 0 ? cameras + 1 : cameras;
    }
    
    /**
     0 -> Not covered by camera
     1 -> Already covered by camera
     2 -> Covered by camera
    **/
    private int dfs(TreeNode root) {
        if (root == null) {
            return 1;
        }
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        if (left == 0 || right == 0 ) {
            cameras++;
            return 2;
        } else if (left == 2 || right == 2) {
            return 1;
        } else {
            return 0;
        }
    }

}