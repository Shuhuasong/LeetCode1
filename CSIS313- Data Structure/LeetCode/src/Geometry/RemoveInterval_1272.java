package Geometry;

public class RemoveInterval_1272 {

}
    //C++ Time Complexity: O(n)
/*
public:
  vector<vector<int>> removeInterval(vector<vector<int>>& intervals, vector<int>& r){
    vector<vector<int>> res;
    //Does not intersect
    for(const auto& i : intervals){
      if(i[1]<=r[0] || r[1]<i=[0]) res.push_back(i);
      else{
        if(i[0]<r[0]) res.push_back({i[0],r[0]});
        if(i[1]>r[1]) res.push_back({r[1], i[1]});
      }
    }
    return res;
  }
 */
