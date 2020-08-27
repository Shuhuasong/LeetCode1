package TwoPointer.medium;

import java.util.Arrays;

public class _826_MostProfitAssignWork {
    //Time: O(NlogN + QlogQ)  Space: O(n)
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);

        int wSize = worker.length;
        int n = difficulty.length;
        int  res = 0;
        Point[] jobs = new Point[n];
        for(int i=0; i<n; i++){
            jobs[i] = new Point(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, (a,b)->a.x - b.x);//sort the job according to job's difficulty
        int j=0, best = 0;
        for(int work  : worker){
            while(j<n && work >= jobs[j].x){
                best = Math.max(best, jobs[j++].y);
            }
            res += best;
        }
        return res;
    }
}
/* create a class to associate the job's difficulty and profit together */
class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
