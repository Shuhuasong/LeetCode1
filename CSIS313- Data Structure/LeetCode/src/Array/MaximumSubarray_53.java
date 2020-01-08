package Array;

//run time: 0 ms, Memory: 37.3 MB
public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums){
        if(nums.length==0 || nums==null) return -1;
        int maxTocur = nums[0];
        int sum = nums[0];
        for(int i=1; i<nums.length; i++){
            maxTocur = maxTocur +  nums[i];
            if(maxTocur<nums[i]) maxTocur = nums[i];
            if(sum<maxTocur) sum = maxTocur;
        }
        return sum;
    }


    //run time: 1 ms, Memory: 37.3 MB
    /*
    public int maxSubArray(int[] nums) {
       int maxTocur = nums[0];
       int sum = nums[0];
        for(int i=1; i<nums.length; i++){
            maxTocur = Math.max(maxTocur+nums[i], nums[i]);
            sum = Math.max(sum, maxTocur);
        }
        return sum;
    }
     */
}
