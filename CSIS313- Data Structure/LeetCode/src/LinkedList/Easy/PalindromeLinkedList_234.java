package LinkedList.Easy;

public class PalindromeLinkedList_234 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Time: O(n) Space: O(1)
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast !=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;
        while(slow != null){
            if(fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
