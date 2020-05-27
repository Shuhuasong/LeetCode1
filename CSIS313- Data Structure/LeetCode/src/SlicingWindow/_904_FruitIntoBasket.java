package SlicingWindow;

import java.util.HashMap;
import java.util.Map;

public class _904_FruitIntoBasket {
    public int totalFruit(int[] tree) {
        if(tree==null || tree.length==0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int lo = 0, hi = 0;
        int maxSize = 0;
        for(hi=0; hi<tree.length; hi++){
            map.put(tree[hi], map.getOrDefault(tree[hi], 0)+1);

            while(map.size()>2){
                map.put(tree[lo], map.get(tree[lo])-1);
                if(map.get(tree[lo])==0) map.remove(tree[lo]);
                lo++;
            }
            maxSize = Math.max(maxSize, hi-lo+1);
        }
        return maxSize;
    }
}

/*
Translation
Find out the longest length of subarrays with at most 2 different numbers?


*/
