package Tree;
//# 538
public class ConvertBSTtoGreaterTree538 {

     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    int totalSum = 0;

    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        convertBST(root.right);
        totalSum += root.val;
        root.val = totalSum;
        convertBST(root.left);
        return root;

       /* TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || node!=null){
            while(node != null){
            stack.push(node);
            node = node.right;
            }
        node = stack.pop();
        totalSum += node.val;
        node.val = totalSum;

        node = node.left;
        }
        return root; */
    }
}
