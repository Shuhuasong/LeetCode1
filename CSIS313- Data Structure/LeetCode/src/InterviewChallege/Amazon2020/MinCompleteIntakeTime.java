package InterviewChallege.Amazon2020;

import java.io.IOException;
import java.util.*;

public class MinCompleteIntakeTime {

    public int minTime(int numOfBuildings, List<Integer> buildingOpenTime, List<Integer> offloadTime){
        Collections.sort(buildingOpenTime);
        Collections.sort(offloadTime);
        int m = buildingOpenTime.size();
        int n = offloadTime.size();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0, maxRes = 0;
        int i=m-1, j=0;
        while(i>=0 && j<n){
            count++;
            int openTime = buildingOpenTime.get(i);
            int loadTime = offloadTime.get(j++);
            maxRes = Math.max(maxRes, openTime+loadTime);
            if(count==4){
                count = 0;
                i--;
            }
        }
        return maxRes;
    }

    public static void main(String args[]) throws IOException{
      MinCompleteIntakeTime test = new MinCompleteIntakeTime();
      int numOfbuilding = 2;
      List<Integer> buildTime = new ArrayList<>(Arrays.asList(8,9,10));
      List<Integer> offloadTime = new ArrayList<>(Arrays.asList(2,2,3,1,8,7,4,5,8,8,8,8));
      int result = test.minTime(numOfbuilding, buildTime, offloadTime);
      System.out.println("result: " + result);
    }
}
