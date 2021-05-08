/**
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
    
    3
   / \
  9   20
      / \
    15   7

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []
 
Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        
        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(Arrays.asList(root));
        
        while(!queue.isEmpty()) {
            List<TreeNode> currentLevel = queue.remove();
            
            List<TreeNode> nextLevel = new LinkedList<>();
            for (TreeNode node: currentLevel) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            
            if (nextLevel.size() != 0) {
              queue.add(nextLevel);   
            }
            
            levels.add(currentLevel.stream().map(n -> n.val).collect(Collectors.toList()));
        }
        
        return levels;
    }
}