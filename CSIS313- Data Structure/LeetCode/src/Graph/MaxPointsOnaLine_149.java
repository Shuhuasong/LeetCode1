package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


//O(n^2) O(n)
public class MaxPointsOnaLine_149 {

    class Point {
      int x;
      int y;
     Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
 /*   public int maxPoints(Point[] points) {
        if(points == null) return 0;
        int n = points.length;
        int ans = 0;

        for(int i=0; i< n; i++){
            HashMap<String, Integer> map = new HashMap<>();
            int duplicate = 0;
            int max = 1;
            for(int j=i+1; j<n; j++){
                int dx = points[j].x-points[i].x;
                int dy = points[j].y-points[i].y;
                if(dx==0 && dy==0){
                    duplicate++;
                    continue;
                }
                int gcd = getGCD(dx, dy);
                int deX = dx/gcd;
                int deY = dy/gcd;
                map.put(deX+"/"+deY, map.getOrDefault(deX+"/"+deY,0)+1);
                max = Math.max(max, map.get(deX+"/"+deY));
            }
            ans = Math.max(max, max+duplicate+1);
        }
        return ans;
    }

    public int getGCD(int a, int b){
        return (b == 0) ? a : getGCD(b, a%b);
    }

  */

    //Time:O(n^2) Space:O(n)
    //run: 13ms (58%)
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n < 2) return n;
        Set<String> set = new HashSet<>();
        int max = 1;
        for(int i=0; i<n && !set.contains(points[i][0]+","+points[i][1]); i++){
            int[] a = points[i];
            int localMax = 1;
            int same = 0;
            Map<Double, Integer> map = new HashMap<>();
            for(int j=i+1; j<n; j++){
                if(isSame(a, points[j])){
                    same++;
                    continue;
                }
                double slope = getSlope(a, points[j]);
                map.put(slope, map.getOrDefault(slope, 1)+1);
                localMax = Math.max(localMax, map.get(slope));
            }
            set.add(a[0]+","+a[1]);
            max = Math.max(max, localMax + same);
        }
        return max;
    }

    private boolean isSame(int[] a, int[] b){
        return a[0]==b[0] && a[1]==b[1];
    }

    private double getSlope(int[] a, int[] b){
        if(a[0]==b[0]) return Double.MAX_VALUE;
        if(a[1]==b[1]) return 0;
        return ((double)a[0]-b[0])/((double) a[1]-b[1]);
    }
}
