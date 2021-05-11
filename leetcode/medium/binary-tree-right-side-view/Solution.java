/**
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example 1:
       1   <---
      / \  
     2   3  <---
      \   \
       5   4  <--

Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:

Input: root = [1,null,3]
Output: [1,3]

Example 3:

Input: root = []
Output: []
 
Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> canSee = new ArrayList<>();
        if (root == null) {
            return canSee;
        }
        
        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(Stream.of(root).collect(Collectors.toList()));
        
        while (!queue.isEmpty()) {
            List<TreeNode> level = queue.remove();
            
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode node: level) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            if (!nextLevel.isEmpty()) {
                queue.add(nextLevel);
            }
            
            canSee.add(level.get(level.size() - 1).val);
        }
        
        return canSee;
    }
}