/**
You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".

Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.

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
    
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        
        if (t == null) {
            return sb.toString();
        }
        
        sb.append(String.valueOf(t.val));
        
        String left = "";
        if (t.left != null) {
            left += "(";
            left += tree2str(t.left);
            left += ")";
        }
     
        String right = "";
        if (t.right != null) {
            right += "(";
            right += tree2str(t.right);
            right += ")";
        }
     
       if (t.left == null && t.right != null) {
            sb.append("()");
            sb.append(right);
        } else {
            sb.append(left);
            sb.append(right);
        }
        
        return sb.toString();
    }
}