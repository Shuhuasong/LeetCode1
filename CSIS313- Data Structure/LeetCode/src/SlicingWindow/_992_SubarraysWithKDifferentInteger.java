package SlicingWindow;

import java.util.HashMap;

public class _992_SubarraysWithKDifferentInteger {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMost(A, K) - atMost(A, K-1);
    }
    private int atMost(int[] A, int K){
        HashMap<Integer, Integer> count = new HashMap<>();
        int res = 0;
        int j = 0;
        for(int i=0; i<A.length; i++){
            if(count.getOrDefault(A[i],0)==0) K--;

            count.put(A[i], count.getOrDefault(A[i], 0)+1);
            while(K<0){
                count.put(A[j], count.get(A[j])-1);
                if(count.get(A[j])==0) K++;
                j++;
            }
            res += i-j+1;
        }
        return res;
    }
}



/*
exactly(K) = atMost(K) - atMost(K-1)

*/