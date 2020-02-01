package LinkedList.Easy;

public class ReverseLinkedList_206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //iterate : Time: O(n) space: O(1)
    public ListNode reverseList(ListNode head) {

            ListNode prev = null;
            if(head == null) return null;
            ListNode cur = head;
            while(cur != null) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }


    //recursive
  /*  public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        return helper(head, null);
    }

    private ListNode helper(ListNode cur, ListNode prev){
        if(cur.next == null){
            cur.next = prev;
            return cur;
        }
        ListNode next = cur.next;
        cur.next = prev;
        return helper(next, cur);
    }

   */
}
