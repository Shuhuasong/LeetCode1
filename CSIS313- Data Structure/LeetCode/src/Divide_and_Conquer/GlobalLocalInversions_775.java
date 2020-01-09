package Divide_and_Conquer;

public class GlobalLocalInversions_775 {

    //run time: 218ms (19.86%)
    //time complexity: O(n^2)
   /* public boolean isIdealPermutation(int[] A) {
        int countL = 0;
        int countG = 0;
        for(int i=0; i<A.length-1; i++){
            if(A[i]>A[i+1]){
                ++countL;
            }
        }

        for(int  i=0; i<A.length; i++){
            for(int j=i+1; j<A.length; j++){
                if(A[i]>A[j] && ++countG>countL){
                    return false;
                }
            }
        }
        return countL==countG;
    }

    */
   //run time: 2ms(97.23%)
    //Time Complexity: O(n) , Space Complexity: O(1)
   //All local inversion are global inverstions
    //if global = local, it means we can't find A[i] > A[j], where
    // j >= i+2; in  other words, max(A[i]) < A[i+2];
    public boolean isIdealPermutation(int[] A) {
        int max = 0;
        for(int i=0; i<A.length; i++){
            max = Math.max(max, A[i]);
            if(max>A[i+2]) return false;
        }
        return true;
    }

}

/*
C++ : run time: 60ms(93.23%)
class Solution {
public:
    bool isIdealPermutation(vector<int>& A) {
        int n = A.size();
        if(n<=2) return true;
        int minNum = A[n-1];
        for(int i=n-3; i>=0; i--){
            if(A[i]>minNum) return false;
            minNum = min(minNum, A[i+1]);
        }
        return true;
    }
};
 */