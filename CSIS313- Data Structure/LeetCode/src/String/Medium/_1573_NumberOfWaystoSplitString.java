package String.Medium;

public class _1573_NumberOfWaystoSplitString {
   //Time: O(n) Space: O(1)
    public int numWays(String s) {
        int MOD = (int)1e9+7;
        int count = 0; //count the total number of one in the string
        long n = s.length();
        for(char c : s.toCharArray()){
            count += (c=='1' ? 1 : 0);
        }
        //no solution
        if(count%3 != 0) return 0;
        //use formula to solve
        if(count==0) return (int)(((n-1)*(n-2)/2)%MOD);
        count /= 3;
        int preSum = 0; // count the first count/3 number of one
        long left = 0, right = 0;
        for(char c : s.toCharArray()){
            if(c=='1') preSum++;
            //we can the first split in another place
            if(preSum==count) left++;
                //we can do the second split in another place
            else if(preSum == count*2) right++;
        }
        return (int)(left*right % MOD);
    }

}


/*
Combination + math


when count = 0, there is no 1 in array
we need to choose two places to cut the string,
that is, C(n-1, 2) = 2! * (n-1)!/(n-3)!

Solution 1: two passes
 #1 pass: count how many ones(count)
 #2 pass: count the frequency of prefix sum of count/3 and count*2/3 as l and r
 And = l * r
 Time complexity: O(n)
 Space complexity: O(1)

 Solution 2: one pass
   Use a hashtable to store the frequency of prefix sum
   Ans = f(count/3) * f(count/3*2)
   Time complexity: O(n)
   Space complexity: O(n)
 */