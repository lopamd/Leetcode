/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if( root == null)
            return;
        TreeLinkNode curr = root,start = null;
        while(curr.left != null){
            start = curr;
            while(start != null){
                start.left.next = start.right;
                if(start.next != null)
                    start.right.next = start.next.left;
                start = start.next;
            }
            curr = curr.left;
        }
    }
}