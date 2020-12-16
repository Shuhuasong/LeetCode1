package LintCode.Sort;

public class _6_MergeTwoSortedArrays {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        // write your code here
        if(A==null && B==null) return new int[0];
        if(A==null) return B;
        if(B==null) return A;
        int m = A.length, n = B.length;
        int i=0, j=0, k=0;
        int[] result = new int[m+n];
        while(i<m && j<n){
            if(A[i] <= B[j]) result[k++] = A[i++];
            else  result[k++] = B[j++];
        }
        while(i<m) result[k++] = A[i++];
        while(j<n) result[k++] = B[j++];
        return result;
    }
}
