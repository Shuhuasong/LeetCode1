package LinkedList.Easy;

import java.util.HashSet;

public class LinkedListCycle_141 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //run time: 0ms 100%
    //Time: O(n) Space: O(1)
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            if(fast.next==null) return false;
            fast = fast.next.next;
            slow = slow.next;
        if(fast==slow)   return true;
        }
        return false;
    }

   //Time: O(n) Space: O(n)
    //run time: 3ms (22%)
   /* public boolean hasCycle(ListNode head) {
        ListNode cur = head;
        HashSet<ListNode>  set = new HashSet<>();

        if(head==null) return false;
        if(head.next == null) return false;
        while(cur != null){
            if(set.contains(cur)) return true;
            else{
                set.add(cur);
                cur = cur.next;
            }
        }
        return false;
    }

    */
}
