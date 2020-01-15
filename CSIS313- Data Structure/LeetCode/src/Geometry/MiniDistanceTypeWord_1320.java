package Geometry;

public class MiniDistanceTypeWord_1320 {

    //Time Complexity: O(26)
    //Space Complexity: O(26)
/*
Assume we tap all letters with only finger.
This the upper bound of our distance tapping with two finger.

Now we can select some letter tapping with the second finger.
We want to know what is the maximum that we can save.

dp[i] means that, the position of our second finger is at character i,
and the maximum we can save is dp[i].

In our dynamic programming, dp[a] means that,
if our left finger ends at character a,
the maximum we can save is dp[a].
 */

    public int minimumDistance(String word) {
        int dp[] = new int[26];
        int res = 0, save = 0, n = word.length();
        for(int i=0; i<n-1; i++){
            int b = word.charAt(i)-'A';
            int c = word.charAt(i+1)-'A';
            for(int j=0; j<26; j++){
                dp[b] = Math.max(dp[b], dp[j]+dist(b,c)-dist(c,j));// we orginally use one finger to go
                //from b->c, but instead use the second finger(j) to go from j->c, then the step we save is dist(b,c)-dist(c,j)
            }
            save = Math.max(save, dp[b]); //when we use second finger
            res += dist(b, c); //when we using one finger, the maximun distance is the sum of all b to c
        }
        return res-save;
    }

    public int dist(int a, int b){
        return Math.abs(a/6-b/6) +
                Math.abs(a%6-b%6) ;
    }


}


//Run Time: 8ms, 9.9 MB
//Time Complexity: O(n*27)
//Space Complexity: O(n*27)=> O(27)
/*
class Solution {
    public:
    int minimumDistance(string word) {
        constexpr int kRest = 26;
        const int n = word.length();

        //dp[i][j]: min cost to type word[0:i]
        //one finger is at word[i-1], another finger is at j
        vector<vector<int>> dp(n+1, vector<int>(27, INT_MAX/2)); //infinite/2

        dp[0][kRest] = 0; //initial place, the first finger cost is 0, the other one is dangling

        auto cost = [](int c1, int c2){
            if(c1 == kRest) return 0;
            return abs(c1/6-c2/6) + abs(c1%6-c2%6);
        };

        for(int i=0; i<n; i++){
            int p = i==0 ? kRest : word[i-1] - 'A';//when i==0, it means that p is dangling
            int c = word[i]-'A';
            for(int j=0; i<=26; j++){
                dp[i+1][j] = min(dp[i+1][j], dp[i][j]+cost(p,c));//same finger
                dp[i+1][p] = min(dp[i+1][p], dp[i][j]+cost(j,c));//other finger
            }
        }
        return *min_element(begin(dp[n]), end(dp[n]));
    }
};
 */



//run time: 12ms 10.2MB
//Time Complexity : O(n*27)
//Space Complexity : O(n*27)
/*  class Solution {
  public:
      int minimumDistance(string word) {
        constexpr int kRest = 26;
        const int = word.length();
        vector<vector<int>> mem(n, vector<int>(27));

        auto const = [](int c1, int c2) {
          if(c1 == kRest) return 0;
          return  abs(c1/6-c2/6) + abs(c1%6-c2%6);
        };
     // min cost to type word[i:n], o is the last position of the other finger
     // the current finger is at word[i-1];
        function<int(int, int)> dp = [&](int i, int o){
          if(i == n) return 0;
          if(mem[i][o]) return mem[i][o];
          int p= i==0 ? kRest : word[i-1] - 'A';
          int c = word[i] - 'A';
          return mem[i][o] = min(dp(i+1, o)+cost(p,c),
                                 dp(i+1, p)+cost(o,c));
        };
        return dp(0,kRest);
     }
  };
  */


