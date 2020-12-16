package LintCode.TwoPointer;

import java.util.Arrays;

public class _382_TriangleCount {
    //Time: O(nlogn)
    public int triangleCount(int[] S) {
        // write your code here
        if(S==null || S.length < 3) return 0;
        Arrays.sort(S);
        int res = 0;
        for(int i=S.length-1; i>=2; i--){
            int l = 0;
            int r = i-1;
            while(l<r){
                if(S[l] + S[r] > S[i]){
                    res = res + r-l;
                    r--;
                }else{
                    l++;
                }
            }
        }
        return res;
    }

   /* public int triangleCount(int[] S) {
        int left = 0, right = S.length-1;
        int res = 0;
        Arrays.sort(S);
        for(int i=0; i<S.length; i++){
            left = 0;
            right = i-1;
            while(left < right){
                if(S[left] + S[right] > S[i]){
                    res = res + right-left;
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }

    */
}
