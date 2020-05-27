package SlicingWindow;

public class _1248_CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int lo = 0, hi = 0, res = 0, count = 0, n = nums.length;
        // sliding window-- right side moving
        for (hi = 0; hi < n; hi++) {
            if (nums[hi] % 2 == 1) {
                k--;
                count = 0;
            }
            // count is used to keep track of number of elements satisfying
            // same count is used until you hit next odd number
            while (k == 0) {
                // try to advance the lo(right) index while k is ZERO
                count++;
                if (nums[lo++] % 2 == 1) {
                    k++;
                }
            }
            res += count;
        }
        return res;
    }
}

/*
every similar with Question 992.Subarrays with K Different Integers
Complexity
Time O(N) for one pass
Space O(1)
*/
