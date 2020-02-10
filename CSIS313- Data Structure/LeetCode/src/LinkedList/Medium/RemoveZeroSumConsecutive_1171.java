package LinkedList.Medium;

import java.util.HashMap;

public class RemoveZeroSumConsecutive_1171 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Time: O(n) Space:O(n)
    //run: 2ms (97%)
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> soFarSum = new HashMap<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int sum = 0;
        for(ListNode cur = dummy; cur != null; cur = cur.next){
            sum += cur.val;
            soFarSum.put(sum, cur);
        }
        sum = 0;
        for(ListNode cur = dummy; cur != null; cur = cur.next){
            sum += cur.val;
            cur.next = soFarSum.get(sum).next;
        }
        return dummy.next;
    }

  /*  //run time: 5ms (31%)
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        helper(dummy);
        return dummy.next;
    }
    public void helper(ListNode head){
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode cur = head;
        int sum = 0;
        int idx = 0;
        while(cur != null){
            sum += cur.val;
            if(map.get(sum)!=null){
                ListNode pre = head;
                for(int i=0; i<map.get(sum); i++){
                    pre = pre.next;
                }
                pre.next = cur.next;
                helper(head);
                return;
            }
            map.put(sum, idx++);
            cur = cur.next;
        }
        return;
    }

   */
}
