package Array.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_56 {
    //Time: O(n)  Space: O(n)
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n < 2) return intervals;
        int m = 0; //count number of stable intervals;
        outer : for(int i=0; i<n; i++){ //outer : labeled break
            for(int j=i+1; j<n; j++){
                if(canMerge(intervals, i, j)){
                    //merge i and j
                    intervals[j][0] = Math.min(intervals[i][0],intervals[j][0]);
                    intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
                    intervals[i] = null; //break outer: break from nested loop to outside of outer loop(labeled loop)
                    continue outer; //starts continue from the labeled loop : outer layer of loop
                }
            }
            m++;
        }

        int[][] ans = new int[m][2];
        int j=0;
        for(int i=0; i<n; i++){
            if(intervals[i] != null){
                ans[j++] = intervals[i];
            }
        }
        return ans;
    }

    private boolean canMerge(int[][] a, int i, int j){
        int first = Math.max(a[i][0], a[j][0]);
        int second = Math.min(a[i][1], a[j][1]);
        return (first <= second);
    }



    //run: 16ms
   /* public int[][] merge(int[][] intervals) {
        if(intervals.length < 2) return intervals;
        Arrays.sort(intervals, (a, b)-> (a[0]-b[0])); //sort by ascending start point
        List<int[]> list = new ArrayList<>();

        list.add(intervals[0]); //add the first interval
        for(int i=0; i<intervals.length; i++){
            if(list.get(list.size()-1)[1] >= intervals[i][0]){ //[1,3][2,6] we can merge
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], intervals[i][1]);
            }else{
                list.add(intervals[i]);//add the current interval to the result list
            }
        }
        //convert the list to Array as expected
        int[][] res = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }

    */
}
