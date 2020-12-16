package Design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {


    /** Initialize your data structure here. */
    Queue<Integer> queue;
    public HitCounter() {
        queue = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!queue.isEmpty() && timestamp-queue.peek() >= 300){
            queue.poll(); //
        }
        return queue.size();
    }
    //Lazy performance: the reason why we put while loop in getHits function instead hit function,
    //because the number of calling the getHits is less than hit function




    /* Initialize your data structure here. */
   /*  HashMap<Integer, Integer> map;
    public HitCounter() {
        map = new HashMap<>();
    }


    public void hit(int timestamp) {
        map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
    }

    public int getHits(int timestamp) {
        int sum = 0;
        for(int key : map.keySet()){
            if(timestamp-key<300){
                sum += map.get(key);
            }
        }
        return sum;
    }
     */
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

/*
1) use Queue: use more memory for the duplicate number, but operation is less
2) use HashMap: use less memory, but the operation is more, because we need to loop through the key set to
calculate the result

 */
