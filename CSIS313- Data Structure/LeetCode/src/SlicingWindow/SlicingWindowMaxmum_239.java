package SlicingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlicingWindowMaxmum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length==0 || k > nums.length) return new int[0];

        int[] res = new int[nums.length-k+1];
        //Deque store the index of max number in window
        Deque<Integer> dq = new ArrayDeque<>();

        int i = 0;

        while(i<nums.length){
            if(!dq.isEmpty() && dq.peekFirst() == i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            //once there is a window, we can add index into res
            if(i>=k-1){
                res[i-k+1] = nums[dq.peekFirst()];
            }
            i++;
        }
        return res;
    }
}
