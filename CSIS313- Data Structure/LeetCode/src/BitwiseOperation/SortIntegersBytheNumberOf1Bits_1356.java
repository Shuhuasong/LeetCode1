package BitwiseOperation;

import java.util.*;

public class SortIntegersBytheNumberOf1Bits_1356 {

    public int[] sortByBits(int[] arr) {
        if(arr==null || arr.length==0) return null;

        int j=0;
        int[] res = new int[arr.length];
        HashMap<Integer, Integer>  map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            int count = Integer.bitCount(arr[i]);
            map.put(arr[i], count);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        List<Map.Entry<Integer, Integer>> listOfEntries = new ArrayList<>(entries);
        Collections.sort(listOfEntries,(x, y) -> x.getValue()-y.getValue());
        int i=0;
        for(Map.Entry<Integer, Integer> entry : listOfEntries){
            res[j++] = entry.getKey();
        }
        return res;
    }


}
