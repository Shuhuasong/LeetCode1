package Tree.BinarySearchTree;

public class _1008_ConstructBinarySearchTreeFromPreOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        int i = 0;

        public TreeNode bstFromPreorder(int[] preorder) {
            return bstBuilder(preorder, Integer.MAX_VALUE);
        }

        private TreeNode bstBuilder(int[] preorder, int bound) {
            if (i == preorder.length || preorder[i] > bound) return null;
            TreeNode root = new TreeNode(preorder[i++]);
            root.left = bstBuilder(preorder, root.val);
            root.right = bstBuilder(preorder, bound);
            return root;
        }
    }
}
