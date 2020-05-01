package DynamicPrograming;

public class _91_DecodeWays {
     /* public int numDecodings(String s) {
       if(s==null || s.length()==0 || s.charAt(0)=='0') return 0;
       int n = s.length();
       int[] dp = new int[n+1];
       dp[0] = 1;
       dp[1] = 1;
       for(int i=1; i<n; i++){
           if(s.charAt(i) != '0'){
               dp[i+1] += dp[i];
           }
           int num = Integer.valueOf(s.substring(i-1, i+1));
           if(num >=10 && num <= 26){
               dp[i+1] += dp[i-1];
           }
       }
        return dp[n];
    }
    */

    public int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0') return 0;
        int n = s.length();
        int curWays = 1;
        int preWays = 1;
        for(int i=1; i<n; i++){
            int tmp = curWays;
            if(s.charAt(i)=='0'){
                curWays = preWays;
                if(s.charAt(i-1) >= '3' || s.charAt(i-1)<='0') return 0;
            }else{
                if(s.charAt(i-1) != '0' && Integer.valueOf(s.substring(i-1, i+1))<=26){
                    curWays += preWays;
                }
            }
            preWays = tmp;
        }
        return curWays;
    }
    /*

     */
}


/*
state: dp[i]  how many choice at position i
init:  dp[0]=1, dp[1]==0 ? 0 : 1
func:  (1) dp[i-1] + dp[i-2] (2) [i] ==0--> dp[i-2]
result: dp[n]
*/