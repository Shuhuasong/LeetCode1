package Queue.PriorityQueue;

import java.util.PriorityQueue;

public class LastStoneWeight_1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y)->y-x);
        for(int num : stones){
            pq.offer(num);
        }
        while(pq.size()>1){
            pq.offer(pq.poll()-pq.poll());
        }
        return pq.peek();
    }
}
