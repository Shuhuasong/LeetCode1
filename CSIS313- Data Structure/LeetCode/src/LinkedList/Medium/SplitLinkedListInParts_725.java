package LinkedList.Medium;

public class SplitLinkedListInParts_725 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //run time:0ms (100%)
    //Time: O(n) Spase: O(1)
    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = 0;
        ListNode cur = root;
        while(cur!= null){
            size++;
            cur = cur.next;
        }
        int n = size/k, rem= size % k;
        ListNode[] ans = new ListNode[k];
        cur = root;
        for(int i=0; i< k; i++){
            ListNode head = cur;
            for(int j=0; j< n + (i<rem ? 1 : 0)-1; j++){

                if(cur != null) cur= cur.next;
            }
            if(cur != null){
                ListNode prev = cur;
                cur = cur.next;
                prev.next = null;
            }
            ans[i] = head;
        }
        return ans;
    }
}
