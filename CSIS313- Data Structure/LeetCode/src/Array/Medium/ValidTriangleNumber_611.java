package Array.Medium;

import java.util.Arrays;

public class ValidTriangleNumber_611 {
    //Time: O(n^2) Space: O(1)
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i > 1; i--) {
            for (int j = 0, k = i - 1; j < k; ) {
                if (nums[j] + nums[k] > nums[i]) {
                    count += k - j; //all the number are valid between j and k
                    k--;
                } else { //not valid: a+b < b
                    j++;
                }
            }
        }
        return count;
    }
}
