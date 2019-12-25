package Tree;

public class CousinsInBT993 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    int depX = -1, depY = -1;
    TreeNode parentX = null, parentY = null;
    public boolean isCousins(TreeNode root, int x, int y){

       depthBinarySearch(root, x, y, root, 0);
       return (depX==depY) && (parentX!= parentY);
    }

      public void depthBinarySearch(TreeNode root, int x, int y, TreeNode parent, int depth){
        if(root==null) return;
        if(root.val == x) {
            depX = depth;
            parentX = parent;
        }
        if(root.val == y){
            depY = depth;
            parentY = parent;
        }
        depthBinarySearch(root.left, x, y, root, depth+1);
        depthBinarySearch(root.right, x, y, root, depth+1);
      }
}
