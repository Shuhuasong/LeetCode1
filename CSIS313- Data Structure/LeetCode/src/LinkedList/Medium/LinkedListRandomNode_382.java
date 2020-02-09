package LinkedList.Medium;

import java.util.Random;

public class LinkedListRandomNode_382 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    class Solution {
        //run:9ms (99.36%)
        ListNode head;
        int size = 0;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
            ListNode cur = head;
            while(cur != null){
                size++;
                cur = cur.next;
            }
        }

        /** Returns a random node's value. */
        public int getRandom() {
            Random r = new Random();
            int x = r.nextInt(size);
            int count = 0;
            ListNode cur = head;
            while(count != x){
                count++;
                cur = cur.next;
            }
            return cur.val;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
}
