package LintCode.Sort;

public class _5_KthLargestElement_QuickSelect {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        if(nums==null) return -1;
        return quickSelect(nums, 0, nums.length-1, n);
    }

    private int quickSelect(int[] nums, int start, int end, int k){
        if(start==end) return nums[start];
        int left = start, right = end;
        int pivot = nums[(left+right)/2];
        while(left <= right){
            while(left<=right && nums[left] > pivot){
                left++;
            }
            while(left<=right && nums[right] < pivot){
                right--;
            }
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if(start + k-1 <= right){
            return quickSelect(nums, start, right, k);
        }
        if(start + k-1 >= left){
            return quickSelect(nums, left, end, k-(left-start));
        }
        return nums[right+1];
    }
}
