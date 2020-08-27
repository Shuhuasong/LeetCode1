package BinarySearch;

import java.util.PriorityQueue;

public class _1337_TheKweakestRowsInAMatrix {
    //Time: O(m * log n*k)  Space: O(k)
    //O(k) : finding the counts  O(m log m) sorting the m keys
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[] counts = new int[m];
        int[] res = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            if(a[1]==b[1]){
                return a[0]-b[0];
            }else{
                return a[1]-b[1];
            }
        });
        for(int i=0; i<m; i++){
            counts[i] = binarySearch(mat[i]);
            pq.add(new int[]{i, counts[i]});
        }
        int i=0;
        while(i<k && !pq.isEmpty()){
            int[] a = pq.poll();
            res[i++]=a[0];
        }
        return res;
    }

    private int binarySearch(int[] row){
        int low = 0;
        int high = row.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if(row[mid]==1){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}
