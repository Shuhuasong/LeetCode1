package Array.Sort;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ListNode {
      int val;
      ListNode next;
      ListNode(int val) {
          this.val = val;
          this.next = null;
      }
  }

public class _104_MergeKSortedLists_LintCode {

    private Comparator<ListNode> listNodeComparator = new Comparator<ListNode>(){
        public int compare(ListNode left, ListNode right){
            return left.val-right.val;
        }
    };

    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if(lists==null) return null;
        //return v1_minHeap(lists);
        //return v2_DivideAndConquer(lists, 0, lists.size()-1);
        return v3_NonRecursive(lists);
    }

    private ListNode v1_minHeap(List<ListNode> lists){
        int k = lists.size();
        PriorityQueue<ListNode> pq = new PriorityQueue<>(k, listNodeComparator);
        for(int i=0; i<k; i++){
            if(lists.get(i)!=null){
                pq.add(lists.get(i));
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            curr.next = node;
            curr = node;
            if(node.next!=null){
                pq.add(node.next);
            }
        }
        return dummy.next;
    }

    private ListNode v2_DivideAndConquer(List<ListNode> lists, int start, int end){
        if(start==end){
            return lists.get(start);
        }
        int mid = start+(end-start)/2;
        ListNode left = v2_DivideAndConquer(lists, start, mid);
        ListNode right = v2_DivideAndConquer(lists, mid+1, end);
        return mergeTwoSortedList(left, right);
    }

    private ListNode v3_NonRecursive(List<ListNode> lists){
        // if(lists==null) return null;
        while(lists.size() > 1){
            List<ListNode> results = new ArrayList<>();
            int k = lists.size();
            for(int i=0; i+1<k; i+=2){
                ListNode curList = mergeTwoSortedList(lists.get(i), lists.get(i+1));
                results.add(curList);
            }
            if(k%2==1){
                results.add(lists.get(k-1));
            }
            lists = results;
        }
        return lists.get(0);
    }

    private ListNode mergeTwoSortedList(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1!=null && l2!=null){
            if(l1.val <=l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1!=null){
            curr.next = l1;
        }
        if(l2!=null){
            curr.next = l2;
        }
        return dummy.next;
    }


}
