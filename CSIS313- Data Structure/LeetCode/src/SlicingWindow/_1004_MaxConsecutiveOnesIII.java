package SlicingWindow;

public class _1004_MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int res = 0, count = 0;
        int i = 0,j = 0;
        for(i=0; i<A.length; i++){
            if(A[i]==0) K--;
            if(K<0 ){
                if(A[j]==0){
                    K++;
                }
                j++;
            }

        }
        return i-j;
    }
    /*
    public int longestOnes(int[] A, int K) {
     int i=0, j=0;
     while(i<A.length){
         if(A[i]==0) K--;
         if(K<0 && A[j++]==0){
                 K++;
          }
         i++;
       }
      return i - j ;
    }
     */
}

/*
Explanation
For each A[j], try to find the longest subarray.
If A[i] ~ A[j] has zeros <= K, we continue to increment j.
If A[i] ~ A[j] has zeros > K, we increment i.



What is a window? Contiguous sub array with some property
What property does the window for this problem require? Must contain at max k 0s but any number of 1s.
How do we represent a window?
pointer for left and right endpoint
variables to describe property of window (here, it's the number of zeros seen so far)
If we exceed having k zeros, then we need to perform an eviction from the left to have a valid window (property cannot be unsatisfied)
 */