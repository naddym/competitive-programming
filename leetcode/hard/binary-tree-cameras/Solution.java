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
    Set<TreeNode> covered = new HashSet<>();
    
    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return cameras;
        }

        // for null nodes from left nodes as parent  
        covered.add(null);
        
        dfs(root, null);
        
        return cameras;
    }
    
    private void dfs(TreeNode root, TreeNode parent) {
        if (root != null) {
            dfs(root.left, root);
            dfs(root.right, root);
            if (parent == null && !covered.contains(root) || !covered.contains(root.left) || !covered.contains(root.right)) {
                cameras++;
                covered.add(root);
                covered.add(parent);
                covered.add(root.left);
                covered.add(root.right);
            }
        }
    }
}