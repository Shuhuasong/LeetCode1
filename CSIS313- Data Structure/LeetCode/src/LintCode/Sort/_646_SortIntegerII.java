package LintCode.Sort;

public class _646_SortIntegerII {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        if(A==null || A.length==0) return;
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length-1, temp);
    }

    private void mergeSort(int[] A, int start, int end, int[] temp){
        if(start >= end) return;

        mergeSort(A, start, (start+end)/2, temp);
        mergeSort(A, (start+end)/2+1, end, temp);
        merge(A, start, end, temp);
    }

    private void merge(int[] A, int start, int end, int[] temp){
        int mid = (start+end)/2;
        int leftIndex = start;
        int rightIndex = mid+1;
        int j = leftIndex;
        while(leftIndex <= mid && rightIndex <= end){
            if(A[leftIndex] < A[rightIndex]) temp[j++] = A[leftIndex++];
            else  temp[j++] = A[rightIndex++];
        }
        while(leftIndex <= mid) temp[j++] = A[leftIndex++];
        while(rightIndex <= end) temp[j++] = A[rightIndex++];
        for(int i=start; i<=end; i++){
            A[i] = temp[i];
        }
    }
}
