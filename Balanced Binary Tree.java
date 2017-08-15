/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        if((leftheight - rightheight) >= 2 || (rightheight - leftheight) >= 2)
            return false;
        else
            return (isBalanced(root.left) && isBalanced(root.right));
         
    }
    
    public int height(TreeNode root){
        if(root == null)
            return 0;
        else
            return 1+Math.max(height(root.left),height(root.right));
    }
}