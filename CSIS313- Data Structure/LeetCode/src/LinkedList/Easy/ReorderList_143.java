package LinkedList.Easy;

public class ReorderList_143 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Time: O(n) Space: O(1)
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        //head of first half list
        ListNode l1 = head;
        //tail of send half list
        ListNode fast = head;
        //head of second half list
        ListNode slow = head;
        //tail of first half list
        ListNode prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l2 = reverse(slow);
        //fast = head;
        merge(l1, l2);

    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public void merge(ListNode l1, ListNode l2){
        while(l1!= null){
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;

            l1.next = l2;

            if(l1_next == null) {
                break;
            }
            l2.next = l1_next;
            l1 = l1_next;
            l2 = l2.next;
        }
    }
}
