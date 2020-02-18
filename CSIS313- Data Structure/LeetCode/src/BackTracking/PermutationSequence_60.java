package BackTracking;

import java.util.ArrayList;

public class PermutationSequence_60 {
    //Time: O(n) Space O(n)
    //run; 1ms (98%)
    public String getPermutation(int n, int k) {
        char[] result = new char[n];
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int[] factorial = new int[n];
        factorial[0] = 1;
        for(int i=1; i<n; i++){
            factorial[i] = factorial[i-1] * i;
        }
        for(int i=1; i<=n; i++){
            nums.add(i);
        }

        k--;//convert k to index
        for(int i=0; i<n; i++){
            result[i] = Character.forDigit(nums.remove(k/factorial[n-1-i]), 10);
            k = k % factorial[n-1-i];
        }
        return new String(result);
    }
}
