package TwoPointer.easy;

public class _977_SquareOfaSortedArray {
    //Time: O(n) Space: O(n)
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int j = 0;
        int[] res = new int[n];
        while(j<n && A[j] < 0){
            j++;
        }
        int i = j-1;
        int idx = 0;
        while(i>=0 && j<n){
            if(A[i] * A[i] < A[j] * A[j]){
                res[idx++] = A[i] * A[i];
                i--;
            }else{
                res[idx++] = A[j] * A[j];
                j++;
            }
        }
        while(i>=0){
            res[idx++] = A[i] * A[i];
            i--;
        }
        while(j<n){
            res[idx++] = A[j] * A[j];
            j++;
        }
        return res;
    }
}

/*
Intuition

Since the array A is sorted, loosely speaking it has some negative elements with squares in decreasing order, then some non-negative elements with squares in increasing order.

For example, with [-3, -2, -1, 4, 5, 6], we have the negative part [-3, -2, -1] with squares [9, 4, 1], and the positive part [4, 5, 6] with squares [16, 25, 36]. Our strategy is to iterate over the negative part in reverse, and the positive part in the forward direction.

Algorithm

We can use two pointers to read the positive and negative parts of the array - one pointer j in the positive direction, and another i in the negative direction.

Now that we are reading two increasing arrays (the squares of the elements), we can merge these arrays together using a two-pointer technique.

 */
