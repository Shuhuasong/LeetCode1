package Array;

// [0,i) : 0
// [i,j) : 1
// [j,k] : unchecked elements
// (k, len-1) : 2

public class SortColors75 {
    public void sortColors(int[] nums) {
        if((nums==null)|| (nums.length<=1)) return;

        int i=0, j=0, k = nums.length-1;
        while(j<=k){
            if(nums[j]==0){
                swap(nums, i++, j++);
            }
            else if(nums[j]==1) j++;
            else if(nums[j]==2){
                swap(nums, j, k--);
            }
        }
    }

    public void swap(int[] nums, int i, int j)   {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
