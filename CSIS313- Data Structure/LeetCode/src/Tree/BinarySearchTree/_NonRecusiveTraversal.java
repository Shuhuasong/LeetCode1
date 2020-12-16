package Tree.BinarySearchTree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class _NonRecusiveTraversal {

    //Iterative---PostOrder(Using two stack)
   /*
    public List<Integer> postOrder(TreeNode root){
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if(root==null) return results;
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode temp = stack1.pop();
            stack2.push(temp);

            if(temp.left!=null){
                stack1.push(temp.left);
            }
            if(temp.right!=null){
                stack1.push(temp.right);
            }
        }
        while(!stack2.isEmpty()){
            results.add(stack2.pop().val);
        }
        return results;
    }

    */

   //One Stack
   public List<Integer> postorderTraversal(TreeNode root) {
       // write your code here
       List<Integer> results = new ArrayList<>();
       Stack<TreeNode> stack = new Stack<>();
       if(root==null) return results;
       stack.push(root);
       TreeNode prev = null;
       while(!stack.isEmpty()){
           TreeNode curr = stack.peek();
            /* go down the tree in search of a leaf an if so process it
            and pop stack otherwise move down */
           if(prev==null || prev.left==curr || prev.right==curr){
               if(curr.left!=null){
                   stack.push(curr.left);
               }else if(curr.right!=null){
                   stack.push(curr.right);
               }else{
                   stack.pop();
                   results.add(curr.val);
               }
                 /* go up the tree from left node, if the child is right
                   push it onto stack otherwise process parent and pop
                   stack */
           }else if(curr.left==prev){
               if(curr.right!=null){
                   stack.push(curr.right);
               }else{
                   stack.pop();
                   results.add(curr.val);
               }
               /* go up the tree from right node and after coming back
                 from right node process parent and pop stack */
           }else if(curr.right==prev){
               stack.pop();
               results.add(curr.val);
           }
           prev = curr;
       }
       return results;
   }

   /* public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> results = new ArrayList<>();
        if(root==null) return results;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }else{
                TreeNode temp = stack.peek().right;
                if(temp==null){
                    temp = stack.pop();
                    results.add(temp.val);
                    while(!stack.isEmpty() && temp==stack.peek().right){
                        temp = stack.pop();
                        results.add(temp.val);
                    }
                }else{
                    curr = temp;
                }
            }
        }
        return results;
    }

    */

    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> results= new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return results;

        while(true){
            if(root!=null){
                stack.push(root);
                root = root.left;
            }else{
                if(stack.isEmpty()) { break; }
                root = stack.pop();
                results.add(root.val);
                root = root.right;
            }
        }
        return results;
    }
}
