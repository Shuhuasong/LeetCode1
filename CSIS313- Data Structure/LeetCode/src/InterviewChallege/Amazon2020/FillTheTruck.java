package InterviewChallege.Amazon2020;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FillTheTruck {


    public FillTheTruck(){ }

  /*  public long getMaxUnit(int num, ArrayList<Integer> boxes, int unitSize, ArrayList<Integer> unitsPerBox, long truckSize){
         PriorityQueue<Integer> pq = new PriorityQueue<>();
         for(int i=0; i<num; i++){
             int n = boxes.get(i);
             for(int j=0; j<n; j++){
                 pq.add(unitsPerBox.get(i));
             }
             while(pq.size() > truckSize){
                 pq.poll();
             }
         }
         int res = 0;
         while(!pq.isEmpty()){
             res += pq.poll();
         }
         return res;
    }

   */

  /*  public long getMaxUnit(int num, ArrayList<Integer> boxes, int unitSize, ArrayList<Integer> unitsPerBox, long truckSize){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for(int i=0; i<num; i++){
            int n = boxes.get(i);
            for(int j=0; j<n; j++){
                pq.add(unitsPerBox.get(i));
                res += pq.peek();
                if(pq.size() > truckSize){
                    res -= pq.peek();
                    pq.poll();
                }
            }
        }
        return res;
    }

   */



    long getMaxUnit(int num, List<Integer> boxes, int unitSize, List<Integer> unitsPerBox, long truckSize) {
        long result = 0;

        Queue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < unitsPerBox.size(); i++) {
            for (int j = 1; j <= boxes.get(i); j++) {
                queue.offer(unitsPerBox.get(i));
            }
        }

        for (int i = 0; i < truckSize && !queue.isEmpty(); i++) {
            result += queue.poll();
        }

        return result;
    }

    /*
     public static long getMaxUnits(List<Long> boxes, List<Long> unitsPerBox, long truckSize) {
    // Write your code here
       long maxUnit = 0;
    //    class NewComparator implements Comparator<Long>{
    //        public int compare(Long s1, Long s2){
    //            return s2-s1 > 0 ? 1 : -1;
    //        }
    //    }
       PriorityQueue<Long> pq = new PriorityQueue<>((a,b)->{
           long res = a - b;
           return res > 0 ? 1 : -1;
       });
       long numBoxes = boxes.size();
       for(int i=0; i<numBoxes; i++){
           for(int j=1; j<=boxes.get(i); j++){
             pq.add(unitsPerBox.get(i));
             if(pq.size() > truckSize){
                 pq.poll();
             }
           }
       }
       while(!pq.isEmpty()){
           maxUnit += pq.poll();
       }
       return maxUnit;
    }

     */




    public static void main(String args[]) throws IOException {
        FillTheTruck fillTruck = new FillTheTruck();
          int num = 4;
//        int[] boxes = {1,2,3};
          int unitSize = 4;
//        int[] unitsPerBox = {3, 2, 1};
//
//
          int truckSize = 11;
           ArrayList<Integer> boxes = new ArrayList<Integer>(List.of(5,6,3,1));
           ArrayList<Integer> unitsPerBox = new ArrayList<Integer>(List.of(4,3,2,1));
           int result = (int) fillTruck.getMaxUnit(num, boxes, unitSize, unitsPerBox, truckSize);
        System.out.println("Result: " + result);
    }
}

//https://leetcode.com/discuss/interview-question/793606/