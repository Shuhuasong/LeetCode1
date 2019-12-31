package LinkedList;

public class RemoveDuplicate83 {


  //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;
        while(curNode != null && curNode.next !=  null){
            if(curNode.val==curNode.next.val){
                curNode.next = curNode.next.next;
            }else{
                curNode = curNode.next;
            }
        }
        return head;
    }
}
