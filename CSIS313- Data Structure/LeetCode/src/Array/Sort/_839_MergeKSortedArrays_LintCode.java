package Array.Sort;

import java.util.Comparator;
import java.util.PriorityQueue;

class Element{
    public int row, col, val;
    public Element(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

public class _839_MergeKSortedArrays_LintCode {
    //Solution#1: put the first element of k arrays into heap, and track this element is from which subArray
    // poll the first element(smallest), and add next element in this subArray when it is available
    //Time = O(N log k) , N is total number of element
    private Comparator<Element> ElementComparator = new Comparator<Element>(){
        public int compare(Element a, Element b){
            return a.val-b.val;
        }
    };

    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        if(arrays==null || arrays.length==0) return new int[0];
        // return mergeHelper_v1_minHeap(arrays);
        // return v2_divideAndConquer(arrays, 0, arrays.length-1);
        return v3_NonRecursive(arrays);
    }

    private int[] v1_minHeap(int[][] arrays){
        int size = 0;
        int k = arrays.length;
        PriorityQueue<Element> pq = new PriorityQueue<Element>(k, ElementComparator);
        for(int i=0; i<k; i++){
            if(arrays[i].length > 0){
                Element elem = new Element(i, 0, arrays[i][0]);
                pq.add(elem);
                size += arrays[i].length;
            }
        }
        int[] results = new int[size];
        int j=0;
        while(!pq.isEmpty()){
            Element elem = pq.poll();
            results[j++] = elem.val;
            if(elem.col + 1 < arrays[elem.row].length){
                elem.col += 1;
                elem.val = arrays[elem.row][elem.col];
                pq.add(elem);
            }
        }
        return results;
    }

    //Time: O(Nlogk)
    private int[] v2_divideAndConquer(int[][] arrays, int start, int end){
        if(start==end){
            return arrays[start];
        }
        int mid = start+(end-start)/2;
        int[] left = v2_divideAndConquer(arrays, start, mid);
        int[] right = v2_divideAndConquer(arrays, mid+1, end);
        return mergeTwoSortedArrays(left, right);
    }

    private int[] v3_NonRecursive(int[][] arrays){
        while(arrays.length>1){
            int n = arrays.length/2;
            if(arrays.length%2 == 1){
                n++;
            }
            int[][] tmp = new int[n][0];
            int index = 0;
            for(int i=0; i<arrays.length && i+1<arrays.length; i+=2){
                int[] merge = mergeTwoSortedArrays(arrays[i], arrays[i+1]);
                tmp[index++] = merge;
            }
            if(arrays.length%2==1){
                tmp[index++] = arrays[arrays.length-1];
            }
            arrays = tmp;
        }
        return arrays[0];
    }

    private int[] mergeTwoSortedArrays(int[] A, int[] B){
        if(A==null) return B;
        if(B==null) return A;
        int m = A.length, n = B.length;
        int size = m+n;
        int[] results = new int[size];
        int i=0, j=0, k = 0;
        while(i<m && j<n){
            if(A[i] <= B[j]){
                results[k++] = A[i++];
            }else{
                results[k++] = B[j++];
            }
        }
        while(i<m){
            results[k++] = A[i++];
        }
        while(j<n){
            results[k++] = B[j++];
        }
        return results;
    }
}
