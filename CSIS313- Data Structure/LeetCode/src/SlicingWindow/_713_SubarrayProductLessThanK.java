package SlicingWindow;

public class _713_SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int prod = 1;
        int res = 0;
        int left = 0, right = 0;
        while(right<nums.length){
            prod *= nums[right];
            while(prod >= k){
                prod /= nums[left];
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}

/*
nums = [10, 5, 2, 6], k = 100
prod = prod * 10;
res = 0-0 + 1;

right = 1
prod = prod * 2 = 10 * 5 = 50
res = res + (1-0) + 1 = 1+2 = 3;
right = 2;

prod = prod * 2 = 10 * 2 = 20
*/
