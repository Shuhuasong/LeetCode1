package Array.TwoDimentionArray;

import java.util.Map;
import java.util.TreeMap;

public class CarPooling_1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        if(trips==null || trips.length==0 || trips[0].length==0) return false;
        Map<Integer, Integer> map = new TreeMap<>();
        for(int[] trip: trips){
            map.put(trip[1], map.getOrDefault(trip[1], 0)+ trip[0]); //the number of get up
            map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]); //the number of get Off
        }
        //check if size >= capacity
        for(int value : map.values()){
            capacity -= value;
            if(capacity < 0)  return false;  // when capacity < 0, it means value > capacity. Value(The number                                         //passengers)
        }
        return true;
    }
}


/*
Keep the size <=capacity
get up?
get off?
map.put(location, num)
TreeMap: store the information with order by key
*/