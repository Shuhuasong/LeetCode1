package Tree;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList_114 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    //run: 1ms (32%)
    //Recursion  Time: O(n)
    public void flatten(TreeNode root) {
        dfs(root);
    }
    //Time: O(h) space: O(1)
    private TreeNode dfs(TreeNode root){
        if(root==null) return null;
        //Keep leftLast and rightLast (PreOrder)
        TreeNode leftLast = dfs(root.left);
        TreeNode rightLast = dfs(root.right);
        //Three Steps: 1) leftLast = root.right; 2) root.right = root.left 3) root.left = null
        if(leftLast != null){
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        //return the last node for next connecting: 1) rightLast != null; 2) leftLast != null; 3) root
        if(rightLast != null) return rightLast;
        if(leftLast != null) return leftLast;
        return root;
    }
    //run: 1ms (32%)
  /*  public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }

            if(!stack.isEmpty()){
                cur.right = stack.peek();
            }
            cur.left = null;
        }
    }

   */
}
