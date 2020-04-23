package Tree.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfaBinaryTree_958 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean found = false;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                found = true;
            } else {
                if (found) return false;
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return true;
    }
}
