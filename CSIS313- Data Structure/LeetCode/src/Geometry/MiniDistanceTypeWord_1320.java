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
 */

    public int minimumDistance(String word) {
        int dp[] = new int[26];
        int res = 0, save = 0, n = word.length();
        for(int i=0; i<n-1; i++){
            int b = word.charAt(i)-'A';
            int c = word.charAt(i+1)-'A';
            for(int j=0; j<26; j++){
                dp[b] = Math.max(dp[b], dp[j]+dist(b,c)-dist(c,j));
            }
            save = Math.max(save, dp[b]);
            res += dist(b, c);
        }
        return res-save;
    }

    public int dist(int a, int b){
        return Math.abs(a/6-b/6) +
                Math.abs(a%6-b%6) ;
    }


}
