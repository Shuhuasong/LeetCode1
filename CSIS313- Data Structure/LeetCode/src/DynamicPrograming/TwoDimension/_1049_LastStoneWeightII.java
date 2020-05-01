package DynamicPrograming.TwoDimension;

public class _1049_LastStoneWeightII {

    //BruteForce Time: O(n*sum) Space: O(sum)
   /* public int lastStoneWeightII(int[] stones) {
         HashSet<Integer> set = new HashSet<>();
         set.add(0);
         for(int num : stones){
             HashSet<Integer> set_temp = new HashSet<>();
             for(int n : set){
                 set_temp.add(num-n);
                 set_temp.add(num+n);
             }
             set = set_temp;
         }

        int min = Integer.MAX_VALUE;
        for(int x : set){
            min = Math.min(min, Math.abs(x));
        }
        return min;
      /*


    }*/

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int a : stones) {
            sum += a;
        }
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = true;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                dp[i][j] = dp[i-1][j];
                if(j>=stones[i-1])
                    dp[i][j] |= dp[i-1][j-stones[i-1]];
            }
        }

        for(int i=sum/2; i>=0; --i)
            if(dp[n][i]) return sum-i-i;

        return 0;
// still counln't understand this dp solution
    }
}

/*

Question: In some version of solution, what does the magic number 1500 mean?
Answer:
The dp[i] present if the sum of one group can be i.
So we can only record the smaller one for less space cost,
which less than half of the upper bound of total sum 3000.

a |= x  --->  a = a | x   | is "bitwise inclusive OR"

https://leetcode.com/problems/last-stone-weight-ii/discuss/509493/Java-Many-Solutions
*/
