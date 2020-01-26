package DynamicPrograming;

public class LongestMountainInArray_845 {
    //Time Complexity: O(n) Space: O(n)
    //run time: 5ms  (13%)
    public int longestMountain(int[] A) {
        int n = A.length, ans = 0;
        int[] inc = new int[n], dec = new int[n];
        for(int i=1; i<n; i++){
            if(A[i]>A[i-1])
                inc[i] = inc[i-1] + 1;
        }
        for(int i=n-2; i>=0; i--){
            if(A[i]>A[i+1])
                dec[i] = dec[i+1] + 1;

            if(inc[i] > 0 && dec[i] > 0){
                ans = Math.max(ans, inc[i] + dec[i] + 1);
            }
        }
        return ans;
    }
}


/*
C++
class Solution {
public:

    //Time Complexity: O(n) Space: O(n)
    //run time: 20ms
  int longestMountain(vector<int>& A) {
    vector<int> inc(A.size());
    vector<int> dec(A.size());

    for (int i = 1; i < A.size(); i++)
      if (A[i] > A[i - 1])
          inc[i] = inc[i - 1] + 1;
    for (int i = A.size() - 2; i > 0; i--)
      if (A[i] > A[i + 1])
          dec[i] = dec[i + 1] + 1;
      int ans = 0;
    for(int i=0; i<A.size(); i++){
        if(inc[i] && dec[i])
            ans = max(ans, inc[i]+dec[i] + 1);
    }
       return ans >= 3 ? ans : 0;
  }
};
 */