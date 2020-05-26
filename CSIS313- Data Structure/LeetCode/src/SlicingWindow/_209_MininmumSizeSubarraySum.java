package SlicingWindow;

public class _209_MininmumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, n = nums.length, i = 0, res = Integer.MAX_VALUE;
        for(int j=0; j<n; j++){  // i : left pointer, j: right pointer
            sum += nums[j];
            while(sum >= s){
                res = Math.min(res, j-i+1);
                sum -= nums[i];
                i++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

/*
Explanation
The result is initialized as res = n + 1.
One pass, remove the value from sum s by doing s -= A[j].
If s <= 0, it means the total sum of A[i] + ... + A[j] >= sum that we want.
Then we update the res = min(res, j - i + 1)
Finally we return the result res


Complexity
Time O(N)
Space O(1)
*/