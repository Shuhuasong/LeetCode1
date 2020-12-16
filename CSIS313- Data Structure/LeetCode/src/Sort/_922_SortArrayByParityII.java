package Sort;

public class _922_SortArrayByParityII {
    //Time: O(n) space: O(1)--Sort in Place
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int j = 1;
        for(int i=0; i<n; i=i+2){
            if(A[i]%2 == 1){
                while(A[j]%2==1){
                    j=j+2;
                }
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}

/*
Idea: the number of even and odd are the same, if we can only focus on
sort the even number on right place, the odd number are sorted automatically.
We scan the array on even index, once find a odd number, we find an next odd place(this place is occupied by even number) to swap them
*/
