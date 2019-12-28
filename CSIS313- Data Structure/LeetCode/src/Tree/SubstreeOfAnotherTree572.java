package Tree;

public class SubstreeOfAnotherTree572 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t==null) return true;
        if(s==null) return false;
        if(s.val==t.val)
            if(equals(s,t)) return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean equals(TreeNode s, TreeNode t){
        if(s==null && t==null) return true;
        if(s==null || t==null) return false;
        if(s.val !=t.val) return false;
        if(equals(s.left, t.left))
            return equals(s.right, t.right);
        return false;
    }
}
