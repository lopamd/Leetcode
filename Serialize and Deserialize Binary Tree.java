/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public static String splitter = ",";
    public static String nullNode = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return null;
        StringBuilder sb  = new StringBuilder();
        doSerialization(root,sb);
        return sb.toString();
        
    }
    public static void doSerialization(TreeNode root, StringBuilder sb){
        if(root == null)
            sb.append(nullNode).append(splitter);
        else
            {
                sb.append(root.val).append(splitter);
                doSerialization(root.left,sb);
                doSerialization(root.right,sb);
            }
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null)
            return null;
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(splitter)));
        return buildTree(queue);
    }
    
    public static TreeNode buildTree(Queue<String> queue){
        String root = queue.remove();
        if(root.equals(nullNode))
            return null;
        else{
            TreeNode node = new TreeNode(Integer.valueOf(root));
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
        }
       
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));