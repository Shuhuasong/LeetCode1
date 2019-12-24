package Tree;

//# 563
public class BinaryTreeTilt563 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }

    int tilt = 0;
    public int findTilt(TreeNode root){
        traversal(root);
        return tilt;
    }
    public int traversal(TreeNode root){
        if(root==null) return 0;
        int left = traversal(root.left);
        int right = traversal(root.right);
        tilt = Math.abs(left - right);
        return left+right+root.val;
    }
}
