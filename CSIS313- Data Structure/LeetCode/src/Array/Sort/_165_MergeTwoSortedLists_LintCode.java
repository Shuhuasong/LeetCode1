package Array.Sort;

public class _165_MergeTwoSortedLists_LintCode {

    /*
    The difference between this question and the question 'Merge Two sorted Array'
    1) List: in-place sort, Array: create extra space for the new array
    2) List: use 'if' the connect the rest of list when it is not empty, the pointer can connect the rest list together in one time
       Array: use 'while' to copy every element into new array
     */

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null){
            curr.next = l1;
        }
        if(l2 != null){
            curr.next = l2;
        }
        return dummy.next;
    }
}
