package LinkedList;

public class SortList_148 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Recursion: 4ms, 40.4 MB;

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(mid));
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(l1!=null){
            tail.next = l1;
        }
        if(l2!=null){
            tail.next = l2;
        }
        return dummy.next;
    }
     /*

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;

        int len = 1;
        ListNode cur = head;
        while(cur!=null) ++len;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l, r, tail;
        for(int i = 1; i<len; i=2*i){
            cur = dummy.next;
            tail = dummy;
            while(cur!=null){
                l = cur;
                r = split(l, i);
                ListNode merge = merge(l, r);
                tail.next = merged.first;
                tail = merged.second;
            }
        }
    }

   public  ListNode split(ListNode head, int n){
        while(--n>0 && head != null){
              head = head.next;}
            ListNode rest = head ?  head.next : null;
            if(head!=null) head.next = null;
            return rest;
   }


     */


}
