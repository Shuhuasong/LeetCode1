package Array.Medium;

public class _413_ArithmeticSlices111 {

   //Solution 1
    // Constant Space- Dynamic Programming
    //Time complexity : O(n) Space: O(1)
    //Transition Function: dp[i] = 1 + dp[i-1]
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        int dp = 0;
        int sum = 0;
        for(int i=2; i<n; i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp = 1 + dp;
                sum += dp;
            }else{
                dp = 0;
            }
        }
        return sum;
    }

    //Solution 2 ---Formula:
    /*
      // Using Formula
    //Time complexity : O(n) Space: O(1)
   //Transition Function: dp[i] = 1 + dp[i-1]
    public int numberOfArithmeticSlices(int[] A) {
      int n = A.length;
      int count = 0;
      int sum = 0;
      for(int i=2; i<n; i++){
          if(A[i]-A[i-1]==A[i-1]-A[i-2]){
             count++;
          }else{
              sum += (count+1)*count/2;
              System.out.println(sum);
              count = 0;// reset count when the common difference is different
          }
      }
        return sum += count*(count+1)/2 ;
    }
     */


    // //Solution 3:  Dynamic Programming
    //Time complexity : O(n)

  /*        0   1   2   3   4   5   6   7    8   9
        A   1   3   5   7   9  15  20  25  28   29
        dp  0   0   1   2   3   0  0   1   0    0

    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        int sum = 0;
        for(int i=2; i<n; i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp[i] = 1 + dp[i-1];
                sum += dp[i];
            }
        }
        return sum;
    }

   */



    /* //Solution 4:  Recursion:  Time: O(n) Space: O(n)
        int res = 0;
        public int numberOfArithmeticSlices(int[] A) {
          slice(A,A.length-1);
          return res;
        }

        public int slice(int[] A, int idx){
            if(idx<2) return 0;
            int sum = 0;
            if(A[idx]-A[idx-1]==A[idx-1]-A[idx-2]){
               sum = 1 + slice(A, idx-1);
               res += sum;
            }else{
                slice(A, idx-1); //exclude the current number
            }
            return sum;
        }

     */

    /*
        Solution 5--Better Brute Force: remove this redundant check in the middle of range,
        and just check the last pair to have the same difference as the one used for the previous range
        Time: O(n^2) Space: O(1)
       public int numberOfArithmeticSlices(int[] A) {
      int n = A.length, res = 0;
      for(int i=0; i<n-2; i++){
         int diff = A[i+1] - A[i];
         for(int k=i+2; k<n; k++){
             if(A[k]-A[k-1]==diff) res++;
             else
                 break;
         }
       }
        return res;
    }
     */



    /*
     Solution 6--Brute Force: iterate over every such slice(range) to check if all the
      consecutive elements within this range have the same difference. For every such
      range found, we can increment the countcount that is used to keep a track of the
      required result.
     //Time: O(n^3) Space: O(1)
    public int numberOfArithmeticSlices(int[] A) {
      int n = A.length, res = 0;
      for(int i=0; i<n-2; i++){
         int diff = A[i+1] - A[i];
         for(int k=i+2; k<n; k++){
             int j = 0;
             for( j=i+1; j<=k; j++){
                 if(A[j]-A[j-1] != diff){
                     break;
                 }
             }
              if(j>k) res++;
         }
       }
        return res;
    }
     */
}


