package DynamicPrograming;

public class _494_TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum < S) return 0;
        int[][] dp = new int[n+1][sum*2+1];
        dp[0][sum] = 1;
        for(int i=0; i<n; i++){
            for(int j=nums[i]; j<2*sum+1-nums[i]; j++){
                if(dp[i][j] > 0){
                    dp[i+1][j+nums[i]] += dp[i][j];
                    dp[i+1][j-nums[i]] += dp[i][j];
                }
            }
        }
        return dp[n][S+sum];
    }

    /*
     public int findTargetSumWays(int[] nums, int S) {
      HashMap<Integer, Integer> map = new HashMap<>();
      map.put(0, 1);
      for(int num : nums){
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int tempSum : map.keySet()){
            int key1 = tempSum+num;
            map2.put(key1, map2.getOrDefault(key1, 0)+ map.get(tempSum));
            int key2 = tempSum-num;
            map2.put(key2, map2.getOrDefault(key2, 0)+ map.get(tempSum));
        }
          map = map2;
      }
        return map.getOrDefault(S, 0);
    }
     */
}


/*
DP :
ways[i][j] # of ways to sum up to j using nums[0~i]
ways[i][j] = ways[i-1][j-nums[i]] + ways[i-1][j+nums[i]]

init: ways[-1][0] = 0 , one way to sum up 0 do nothing
Ans: ways[n-1][S]

Time: O(n * sum)
Space: O(n * sum) --> O(n)

*/