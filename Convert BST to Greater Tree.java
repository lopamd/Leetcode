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
    public TreeNode convertBST(TreeNode root) {
        GST(root);
        return root;
    }
    int sum = 0;
    public void GST(TreeNode root){
        if(root == null)
            return;
        GST(root.right);
        root.val += sum;
        sum = root.val;
        GST(root.left);
    }
}