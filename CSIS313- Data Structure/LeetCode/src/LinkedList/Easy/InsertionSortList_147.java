package LinkedList.Easy;

public class InsertionSortList_147 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Time: O(n)  Space: O(1)
    //run: 2ms (99%)
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = null;
        ListNode temp = null;
        while(cur != null && cur.next != null){
            if(cur.val <= cur.next.val){
                cur = cur.next;
            }else{
                temp = cur.next;
                cur.next = cur.next.next;
                prev = dummy;
                while(prev.next.val <= temp.val){
                    prev = prev.next;
                }
                temp.next = prev.next;
                prev.next = temp;
            }
        }
        return dummy.next;
    }
}
