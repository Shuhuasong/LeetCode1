package Tree.BinarySearchTree;

import javax.swing.tree.TreeNode;
import java.util.Stack;

public class _938_RangeSumOfBST {

 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


    //DFS : Recursive
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null) return 0;
        return sumBST(root, L, R);
    }
    public int sumBST(TreeNode root, int L, int R){
        if(root==null) return 0;
        if(root.val >= L && root.val <= R){
            sum += root.val;
        }
        if(root.val > L)
            sumBST(root.left, L, R);
        if(root.val < R)
            sumBST(root.right, L, R);
        return sum;
    }

    //DFS : iterative
    //Time: O(n)  Space: O(h) h: the height of tree

 /*   public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            if(node != null){
                if(node.val >= L && node.val <= R){
                    sum += node.val;
                }
                if(node.val > L) st.push(node.left);
                if(node.val < R) st.push(node.right);
            }
        }
        return sum;
    }

  */
}
