package LinkedList.Easy;

public class LinkedListCycleII_142 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast) { //slow and fast meet
                break;
            }
        }
        if(fast == null || fast.next==null){ // there is no cycle
            return null;
        }

        fast = head; //there is a cycle
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
