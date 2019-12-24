package Tree;
//# 965
public class UnivaluedBinaryTree965 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }

    public boolean isUnivalTree(TreeNode root) {
        return traversal(root) ;
    }

    public boolean traversal(TreeNode root){
        if(root==null) return true;
        else if(root.left !=null && root.right !=null){
            if(root.left.val==root.val && root.right.val==root.val){
                return ( traversal(root.left) && traversal(root.right));
            }
            else return false;
        }
        else if(root.left==null && root.right!=null){
            if(root.right.val==root.val)
                return traversal(root.right);
            else
                return false;
        }
        else if(root.left!=null  && root.right==null){
            if(root.left.val==root.val)
                return traversal(root.left);
            else
                return false;
        }
        return true;
    }
}
