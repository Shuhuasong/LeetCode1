package SlicingWindow;

import java.util.ArrayList;
import java.util.List;

public class _986_IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int m = A.length, n = B.length;
        int i = 0, j = 0;
        while(i<m && j<n){
            int begin = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            if(begin<=end){
                list.add(new int[]{ begin, end });
            }
            if(A[i][1] < B[j][1]){ i++; }
            else{
                j++;
            }
        }
        int[][] res = new int[list.size()][2];
        int k = 0;
        for(int[] arr : list){
            res[k++] = arr;
        }
        return res;
    }
}
