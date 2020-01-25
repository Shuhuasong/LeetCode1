package String.Palindrome;

public class PalindromePartitioningII_132 {

    //Time Complexity: O(n^3)
    //run time: 343ms  (10.75%)
    public int minCut(String s) {
       boolean valid[][] = new boolean[s.length()][s.length()];
       int dp[] = new int[s.length()];
       for(int i=0; i<s.length(); i++){
           for(int j=i; j<s.length(); j++){
               if(i==j){
                   valid[i][j] = true;
               }
               else{
                   valid[i][j] = isPalindrome(s, i, j);
               }
           }
       }
       //check the min in dp
        for(int col = 1; col<s.length(); col++){
            int val = Integer.MAX_VALUE;
            for(int i=0; i<=col; i++){
                if(valid[i][col]==true){
                    if(i==0){
                        val = 0;
                        break;
                    }
                    val = Math.min(val, dp[i-1]+1);
                }
            }
            dp[col] = val;
        }
       return dp[dp.length-1];
    }

    public boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}



/*
C++

// //Time Complexity: O(n*n), Space Complexity: O(n*n)
// run time: 28ms (54%) 21.9 MB
class Solution {
public:
    int minCut(string s) {

        const int n = s.length();
        //valid[i][j] = 1 if s[i~j] is palindrome, otherwise 0
        vector<vector<int>> valid(n, vector<int>(n, 1));

        //dp[i] = min cuts of s[0~i]
        vector<int> dp(n, n);

        for(int l=2; l <= n; ++l)
            for(int i=0, j = i+l-1; j<n; ++i, ++j)
                valid[i][j] = s[i] == s[j] && valid[i+1][j-1];
        for(int i=0; i<n; ++i){
            if(valid[0][i]){
                dp[i]=0;
                continue;
            }
            for(int j=0; j<i; ++j)
                if(valid[j+1][i])
                    dp[i] = min(dp[i], dp[j]+1);
        }
        return dp[n-1];
    }
};
 */