package LinkedList;

public class AddTwoNumbers_2 {

    //Definition for singly-linked list.
             public class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
   }
// rumTime: 1ms   Memory: 44.5MB
  /*  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curNode = dummyNode;
        int carry  = 0;
        while(p != null || q!=null){
            int x = (p!=null) ? p.val : 0;
            int y = (q!=null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum/10;
            curNode.next = new ListNode(sum%10);
            curNode = curNode.next;
            if(p!=null) p = p.next;
            if(q!=null) q = q.next;
        }
        if(carry>0){
            curNode.next = new ListNode(carry);
        }
        return dummyNode;
    }

   */

    // rumTime: 2ms   Memory: 42.9MB

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummyNode = new ListNode(0);
        ListNode curNode = dummyNode;

        int sum = 0;
        while(l1!=null || l2!=null || sum!=0){
            if(l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            curNode.next = new ListNode(sum%10);
            curNode = curNode.next;
            sum = sum/10;
        }
        return dummyNode.next;
    }

}
