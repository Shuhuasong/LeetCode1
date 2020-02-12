package Tree;

public class PathSum_112 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    //Time: O(n) Space: O(1)
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) {
            return false;
        } else if(root.left == null && root.right == null && sum-root.val==0)  {return true;  }
        else {
            return (hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val));
        }
    }
}
