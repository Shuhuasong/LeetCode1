package SlicingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class _862_ShortestSubarrayWithSumAtLeastK {
    //Time and Space: O(n)
    public int shortestSubarray(int[] A, int K) {
        int n = A.length, res = n+1;
        int[] preSum = new int[n+1];
        //// The is queue of index which maintains only those index which is having
        // monotonically increasing prefix sum
        Deque<Integer> dq = new ArrayDeque<>();
        for(int j=0; j<n; j++) preSum[j+1] = preSum[j] + A[j];

        for(int i=0; i<n+1; i++){ //Indexes can only be in the queue if the current index being scanned is having a higher prefixSum
            while(dq.size() > 0 && preSum[i]-preSum[dq.getFirst()] >= K)
                res = Math.min(res, i-dq.pollFirst());
            while(dq.size() > 0 && preSum[i] <= preSum[dq.getLast()]){ //To keep B[dq[i]] increasing in the deque.
                dq.pollLast(); //pop all indexes from the front which satisfies the criteria PrefixSum(current index) - PrefixSum(front index) >= k
            }
            dq.addLast(i);
        }
        return res <= n ? res : -1;
    }
}

/*
Why we pop left in the first while loop?
This the most tricky part that improvesolution to get only O(N).
D[0] exists in our deque, it means that before B[i], we didn't find a subarray whose sum at least K.
B[i] is the first prefix sum that valid this condition.
In other words, A[D[0]] ~ A[i-1] is the shortest subarray starting at A[D[0]] with sum at least K.
We have already find it for A[D[0]] and it can't be shorter, so we can drop it from our deque.
*/
