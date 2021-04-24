/**
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

Example 1:
  
  1        1          2             3      3
   \        \       /   \          /      /
    3        2     1     3        2      1
   /          \                  /        \ 
  2            3                1          2  
Input: n = 3
Output: 5

Example 2:

Input: n = 1
Output: 1
 
Constraints:

1 <= n <= 19

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
    
    public List<TreeNode> generateTrees(int n) {        
        return uniqueBST(1, n);
    }
    
    private List<TreeNode> uniqueBST(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            return trees;
        }
        
        if (start == end) {
            trees.add(new TreeNode(end));
            return trees;
        }
        
        
        for (int i = start; i <= end ; i++) {
            
            List<TreeNode> leftSubtrees = uniqueBST(start, i - 1);
            List<TreeNode> rightSubtrees =  uniqueBST(i + 1, end);
 
            if (leftSubtrees.size() == 0 && rightSubtrees.size() == 0) {
                trees.add(new TreeNode(i));
            } else if (leftSubtrees.size () == 0 && rightSubtrees.size() != 0) {
                
                for (TreeNode right: rightSubtrees){
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.right = right;
                    trees.add(treeNode);
                }
                
            } else if (leftSubtrees.size() != 0 && rightSubtrees.size() == 0) {
    
                for (TreeNode left: leftSubtrees ){
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    trees.add(treeNode);
                }
                
            } else {
                
                for (TreeNode l: leftSubtrees) {
                    for (TreeNode r: leftSubtrees) {
                        TreeNode treeNode = new TreeNode(i);
                        treeNode.left = l;
                        treeNode.right = r;
                        trees.add(treeNode);
                    }
                }                
            }
        }
        
        return trees;
    }
}