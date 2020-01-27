package DynamicPrograming;

import java.util.Arrays;

public class LongestArithmetricSubsequence_1027 {
    //run time: 14ms (95.93%)
    //Time Complexity: O(n^2) Space: O(n)
    public int longestArithSeqLength(int[] A) {
        int n = A.length;
        int dp[][] = new int[n][n];
        int index[] = new int[20001];
        Arrays.fill(index, -1);

        int max = 2;
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], 2);
            for(int j=i+1; j<n; j++){
                int first = 2 * A[i] - A[j];
                if(first < 0 || index[first] < 0) continue;
                dp[i][j] = dp[index[first]][i] + 1;
                max = Math.max(max, dp[i][j]);
            }
            index[A[i]] = i;
        }
        return max;
    }
}
