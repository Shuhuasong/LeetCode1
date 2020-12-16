package LintCode.TwoPointer;

import java.util.Arrays;

public class _59_3SumClosest_LintCode {
    public int threeSumClosest(int[] A, int target) {
        // write your code here
        if(A.length<3) return 0;
        Arrays.sort(A);
        int bestSum = A[0] + A[1] + A[2];
        int n = A.length;
        for(int i=0; i<n; i++){
            int left = i+1, right = n-1;
            while(left < right){
                int sum = A[i] + A[left] + A[right];
                if(Math.abs(sum-target) < Math.abs(bestSum-target)){
                    bestSum = sum;
                }
                if(sum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return bestSum;
    }
}
/*
排序后。 固定一个点，利用双指针的方式，扫描，记录答案即可。
*/