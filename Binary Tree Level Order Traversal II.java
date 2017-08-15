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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
            return result;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> childList = new LinkedList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
                childList.add(curr.val);
            }
            result.add(0,childList);
        }
        return result;
    }
}