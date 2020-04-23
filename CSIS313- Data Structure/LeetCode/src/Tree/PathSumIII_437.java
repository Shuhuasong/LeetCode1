package Tree;

public class PathSumIII_437 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        //root + left + right
        return dfs(root, sum) + dfs(root.left, sum)+dfs(root.right, sum); //because every node can be a start node
    }

    private int dfs(TreeNode root, int sum){
        if(root==null) return 0;

        sum -=root.val;

        return (sum==0 ? 1 : 0) + dfs(root.left, sum) + dfs(root.right, sum);
    }
}
