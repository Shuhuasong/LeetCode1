package InterviewChallege.Amazon2020;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class AnalyzeHardDisk {

    public AnalyzeHardDisk() { }

  /*  public static int analyzeDisk(int numComp, int[] diskSpace, int segLen){
        int i=0, maxDisk = Integer.MIN_VALUE;
        int sumDisk = 0;
        for(int j=0; j<numComp; j++){
            sumDisk += diskSpace[j];
            if(j-i+1>segLen){
                sumDisk -= diskSpace[j];
                maxDisk = Math.max(maxDisk, sumDisk);
                i++;
            }
        }
        return maxDisk;
    }

   */

    public int analyse(int numComputer, int[] hardDiskSpace, int segmentLength) {
        Deque<Integer> deq = new ArrayDeque<>();
        int maxMin = Integer.MIN_VALUE;
        for(int i = 0; i < numComputer; i++) {
            while(!deq.isEmpty() && hardDiskSpace[deq.peekLast()] > hardDiskSpace[i]) {
               // System.out.println("Last: "+deq.peekLast());
                deq.pollLast();
            }
            if(!deq.isEmpty() && deq.peekFirst() <= (i - segmentLength)) {
                //System.out.println("First: "+deq.peekFirst());
                deq.pollFirst();
            }
            deq.offerLast(i);
            if(i >= (segmentLength - 1)) {
                System.out.println("First: "+hardDiskSpace[deq.peekFirst()] + " maxMin: " + maxMin );
                maxMin = Math.max(maxMin, hardDiskSpace[deq.peekFirst()]);
            }
        }
        return maxMin;
    }

    public static void main(String args[]) throws IOException{
        AnalyzeHardDisk disk = new AnalyzeHardDisk();
        int numComp = 6;
        int[] diskSpace = {8, 2,4,3,7,6};
        int segLen = 3;
        int result = disk.analyse(numComp, diskSpace, segLen);
        System.out.println("result: " + result);
    }
}
