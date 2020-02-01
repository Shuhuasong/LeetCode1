package LinkedList.Easy;

public class SwapNodesInPairs_24 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //time: O(n) Space: O(1)
    //run : 0ms (100%)
    public ListNode swapPairs(ListNode head) {
        if(head==null ||head.next==null) return head;

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        dummy.next = head;

        while(cur.next != null && cur.next.next != null){
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            cur.next = second;
            first.next = second.next;
            second.next = first;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
