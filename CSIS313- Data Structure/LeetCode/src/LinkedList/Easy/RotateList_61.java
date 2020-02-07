package LinkedList.Easy;

public class RotateList_61 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //Time: O(n) Space: O(1)
   /* public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        while(fast != null){
            len++;
            fast = fast.next;
        }
        fast = head;
        for(int i=0; i<k%len; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    */

    //find the head
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        while(fast != null){
            len++;
            fast = fast.next;
        }
        fast.next = head;
        for(int i=0; i<len-k%len; i++){
            fast = fast.next;
        }
        ListNode ans = fast.next;
        fast.next = null;
        return ans;
    }
}
