package LinkedList.Easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists_160 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Time: O(n)  Space: O(1)
    //run time: 1ms (92%)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != curB){

            if(curA == null){
                curA = headB;
            }else{
                curA = curA.next;
            }

            if(curB == null){
                curB = headA;
            }else{
                curB = curB.next;
            }
        }
        return curA;
    }
/*
//  Time: O(n) Space: O(n)
// Run time: 7ms (26%)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        Set<ListNode> set = new HashSet<>();
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

 */
}
