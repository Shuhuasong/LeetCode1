package Array;

public class RangeSumQuery_303 {
    //Using Prefix Sum
    class NumArray {
        int[] preSum;
        public NumArray(int[] nums) {
            preSum = new int[nums.length+1];
            for(int i=1; i<=nums.length; i++){
                preSum[i] = preSum[i-1] + nums[i-1];
            }
        }

        public int sumRange(int i, int j) {
            return preSum[j+1]-preSum[i];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}
