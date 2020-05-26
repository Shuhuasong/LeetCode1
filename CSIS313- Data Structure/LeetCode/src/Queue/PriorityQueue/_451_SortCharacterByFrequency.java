package Queue.PriorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _451_SortCharacterByFrequency {
    public String frequencySort(String s) {
        if(s==null || s.length()==0) return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Map.Entry<Character, Integer>> minHeap = new PriorityQueue<>((a, b)-> b.getValue()- a.getValue());
        minHeap.addAll(map.entrySet());
        while(!minHeap.isEmpty()){
            Map.Entry<Character, Integer> curMap = minHeap.poll();
            for(int i=0; i<curMap.getValue(); i++){
                sb.append(curMap.getKey());
            }
        }
        return sb.toString();
    }
}
