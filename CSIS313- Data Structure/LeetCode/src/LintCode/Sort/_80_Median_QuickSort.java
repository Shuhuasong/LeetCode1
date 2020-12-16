package LintCode.Sort;

public class _80_Median_QuickSort {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        // write your code here
        if(nums==null) return -1;
        int n = nums.length;
        quickSort(nums, 0, nums.length-1);
        return n%2==0 ? nums[n/2-1] : nums[n/2];
    }

    public void quickSort(int[] nums, int start, int end){
        if(start >= end) return;
        int l = start, r = end;
        int pivot = nums[(l+r)/2];
        while(l<=r){
            while(l<=r && nums[l] < pivot){
                l++;
            }
            while(l<=r && nums[r] > pivot){
                r--;
            }
            if(l<=r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }
        quickSort(nums, start, r);
        quickSort(nums, l, end);
    }
}
