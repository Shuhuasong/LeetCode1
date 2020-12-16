package DynamicPrograming;

import java.util.HashSet;
import java.util.Set;

public class _LintCode683_WordBreakIII {
    public int wordBreak3(String s, Set<String> dict) {
        // Write your code here
        //设dpi表示从字典dict中组成子串stri:j+1有多少种方法。 转移方程为：
        //dp[i][j]表示s[i:j+1]的拆分方法数

        int n = s.length();
        String lowerS = s.toLowerCase();
        Set<String> lowerDict = new HashSet<>();
        for(String word : dict){
            String str = word.toLowerCase();
            lowerDict.add(str);
        }
        //dp[i] means the number of ways that string s[0:i] can be seperated
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(lowerDict.contains(lowerS.substring(i, j+1))){
                    dp[j+1] += dp[i];
                }
            }
        }
        return dp[n];
    }

   /* public int wordBreak3(String s, Set<String> dict) {
        // Write your code here
        //设dpi表示从字典dict中组成子串stri:j+1有多少种方法。 转移方程为：
        //dp[i][j]表示s[i:j+1]的拆分方法数
        int n = s.length();
        String lowerS = s.toLowerCase();
        Set<String> lowerDict = new HashSet<>();
        for(String word : dict){
            String str = word.toLowerCase();
            lowerDict.add(str);
        }
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                String strs = lowerS.substring(i, j+1);
                if(lowerDict.contains(strs)){
                    dp[i][j] = 1;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                for(int k=i; k<j; k++){
                    dp[i][j] += dp[i][k] * dp[k+1][j];
                }
            }
        }
        return dp[0][n-1];
    }

    */
}

/*
根据题目给出的描述，我们稍加思考，可以意识到对于句子s，我们可以拆分成s1和s2，那么根据乘法原理，s的拆分方法数就等于s1的拆分方法数乘以s2的拆分方法数，由此我们想到动态规划。

算法思路
我们定义状态dp[i][j]表示s[i:j+1]的拆分方法数

状态转移方程为
         dp[i][j] = SUM ( dp[i][k] * dp[k+1][j] ) ( i<= k < j )
代码思路
本题忽略大小写，所以先将所有字符转化为小写
先将dict中与s的子串匹配，计算出初始的dp数组
枚举i和j，即s的所有子串，再枚举分割位置k计算出每一个子串的拆分方法数
返回答案dp[0][n-1]
复杂度分析
空间复杂度：O(N^2)
时间复杂度：O(N^3)
优化
我们可以将状态定义成一维数组,dp[i]表示s[0:i+1]的拆分方法数
转移也不再是枚举中间的分割位置，而是枚举接在s[0:i+1]后面的串
优化后复杂度分析
空间复杂度：O(N)
时间复杂度：O(N^2 logN) 判断一个子串是否存在于dict使用hash判断，需要logN的复杂度
 */

