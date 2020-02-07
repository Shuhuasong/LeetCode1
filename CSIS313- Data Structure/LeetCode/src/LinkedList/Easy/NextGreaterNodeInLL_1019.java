package LinkedList.Easy;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterNodeInLL_1019 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Time: O(n) Space: O(n)
    //run time: 15ms (90%)
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            arr.add(cur.val);
            cur = cur.next;
        }

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            while(!stack.isEmpty() && arr.get(stack.peek())<arr.get(i)){
                ans[stack.pop()] = arr.get(i);
            }
            stack.push(i);

        }
        return ans;
    }
}
