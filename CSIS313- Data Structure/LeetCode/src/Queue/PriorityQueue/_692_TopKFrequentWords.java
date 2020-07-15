package Queue.PriorityQueue;

import java.util.*;

public class _692_TopKFrequentWords {
    //Time: O(N log k)      logk:heap   space: O(n)
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(String str : words){
            map.put(str, map.getOrDefault(str, 0)+1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2)->
        { if(map.get(w1) == (map.get(w2)))
            return  w2.compareTo(w1);
        else
            return  map.get(w1) - map.get(w2);
        });


        for(String word: map.keySet()){
            pq.offer(word);
            if(pq.size() > k) pq.poll();
        }

        while(!pq.isEmpty()){
            //System.out.println(pq.poll());
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
