package BackTracking;

public class NextPermutation_31 {
    //Bruce force: O(n!)
    //Time: O(n) Space: O(1)
    public void nextPermutation(int[] nums) {
        //find the first pair that num[i] < num[i+1]
        //1 2 5 8 7
        int n = nums.length;
        int i = n-2; //want to make the num[i+1] validate
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        // 1 2 7 8 5
        // Find the first element, which is greater the nums[i]
        if(i>=0){
            int j = n-1;
            while(j>=0 && nums[i] >= nums[j]){
                j--;
            }
            // // swap them
            swap(nums, i, j);
        }
        // reverse the 8 5 -> 5 8
        reverse(nums, i+1, n-1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int low, int high){
        while(low < high){
            swap(nums, low++, high--);
        }
    }

}
