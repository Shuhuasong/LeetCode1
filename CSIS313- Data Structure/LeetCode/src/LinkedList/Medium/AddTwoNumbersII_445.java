package LinkedList.Medium;

import java.util.Stack;

public class AddTwoNumbersII_445 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    //4ms (61%)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int total = 0;
        ListNode iter = new ListNode(-1);
        while(!s1.empty() || !s2.empty()){
            if(!s1.empty()) total += s1.pop();
            if(!s2.empty()) total += s2.pop();
            iter.val = total % 10;
            ListNode head = new ListNode(total / 10);
            head.next = iter;
            iter = head;
            total /= 10;
        }
        return iter.val==0? iter.next: iter;
    }
}
