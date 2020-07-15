package Queue.PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _973_KClosestPointsToOrigin {
    //Time: O(n log k)


    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->
                b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1]);
        for(int[] point : points){
            pq.offer(point);
            if(pq.size()>K){
                pq.poll();
            }
        }
        return   pq.toArray(new int[pq.size()][2]);
    }
//pq.toArray(arr[])  Parameters: The method accepts one parameter arr[] into which all of the elements of the queue are to be copied.

  /*  public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparing(p->p[0]*p[0]+p[1]*p[1]));
        return Arrays.copyOfRange(points, 0, K);
    }
   */
}
