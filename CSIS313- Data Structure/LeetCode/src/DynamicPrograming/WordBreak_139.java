package DynamicPrograming;

import java.util.HashSet;
import java.util.List;

public class WordBreak_139 {

        //run time: 8ms (16.16%)
    //Time
      /* public boolean wordBreak(String s, List<String> wordDict) {
            if(s==null || wordDict==null) return false;

            HashSet<String> dict = new HashSet<>();

            boolean[] breakable = new boolean[s.length()+1];
            breakable[0] = true;
            for(String str : wordDict){
                dict.add(str);
            }

            for(int i=0; i<=s.length(); i++){
                for(int j=i; j>0; j--){
                    String str = s.substring(i-j, i);
                    if(dict.contains(str)){
                        if(breakable[i-j]==true){
                            breakable[i] = true;
                            break;
                        }
                    }
                }
            }
            return breakable[s.length()];
        }

       */

    //run time: 8ms (16.16%)
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

