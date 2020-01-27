package DynamicPrograming;

public class DominoAndTrominoTiling_790 {

    public int numTilings(int N) {
        //run time: 1ms (70%) (36.6MB)
        // Time: O(n), Space: O(n)
        /*
        dp[i][0]: both rows have length i;
dp[i][1]: one row has length i and the other i - 1;
dp[i][2]: one row has length i and the other i - 2.
        */
        final int mod = 1000000007;
        int[][] dp = new int[N + 1][3];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][2] = dp[i - 2][0];
            dp[i][1] = (dp[i - 1][1] + dp[i - 2][0]) % mod;
            dp[i][0] = ((dp[i][2] + dp[i - 1][0]) % mod + (dp[i - 1][1] * 2) % mod) % mod;
        }
        return dp[N][0];
    }
}
