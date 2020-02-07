package LinkedList.Easy;

import java.util.ArrayList;

public class ConvertBinaryNum_1290 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Time: O(n) Space: O(1)
    public int getDecimalValue(ListNode head) {
        int count = -1;
        int ans = 0;
        ListNode cur = head;

        while(cur != null){
            count++;
            cur = cur.next;
        }
        while(head != null){
            if(head.val==1){
                ans += Math.pow(2, count);
            }
            count--;
            head = head.next;
        }
        return ans;
    }
}
