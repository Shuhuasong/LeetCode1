package Geometry;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

//Time Complexity: O(n)
public class KclosestPoint_973 {
    public int[][] kClosest(int[][] points, int K) {
      PriorityQueue<int[]> pq = new PriorityQueue<>(
              (a, b)->b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1] //the comparator
      );
      for(int[] point : points){
          pq.add(point);
          if(pq.size() > K){
              pq.poll(); //remove the element on the top, that are the furthest elements
          }
      }
      return pq.toArray((new int[pq.size()][2]));
    }
}

/*
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int K) {
        vector<pair<int, int>> sortArr;
        for(int i=0; i<points.size(); i++){
            sortArr.emplace_back(points[i][0]*points[i][0] + points[i][1]*points[i][1], i);
        }
        sort(sortArr.begin(), sortArr.end());
        vector<vector<int>> ans;
        for(int i=0; i< K; i++){
            ans.push_back(points[sortArr[i].second]);
        }
        return ans;
    }
 */