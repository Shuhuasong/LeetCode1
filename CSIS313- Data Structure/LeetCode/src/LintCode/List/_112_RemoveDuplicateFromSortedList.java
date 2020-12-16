package LintCode.List;

public class _112_RemoveDuplicateFromSortedList {
    /**
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
      public class ListNode {
      int val;
      ListNode next;
     ListNode(int x) {
          val = x;
          next = null;
     }
  }
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head==null) return null;
        ListNode cur = head;

        while(cur!=null && cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
}
