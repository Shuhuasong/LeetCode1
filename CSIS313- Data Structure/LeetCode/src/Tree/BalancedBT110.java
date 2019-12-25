package Tree;

public class BalancedBT110 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        int leftH = height(root.left);
        int rightH = height(root.right);
        System.out.println(leftH);
         if(Math.abs(leftH-rightH)<= 1)
             return isBalanced(root.left) && isBalanced(root.right);
         return false;
    }

    public int height(TreeNode node){
      if(node==null) return 0;
      return 1 + Math.max(height(node.left),height(node.right));
    }
}
