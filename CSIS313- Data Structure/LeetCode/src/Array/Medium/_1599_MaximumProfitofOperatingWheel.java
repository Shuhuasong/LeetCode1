package Array.Medium;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class _1599_MaximumProfitofOperatingWheel {

    public _1599_MaximumProfitofOperatingWheel() {
    }


    int cost = 0, res = Integer.MIN_VALUE, times = 0;
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int n = customers.length;
        int totalCus = 0, onBoard = 0;
        int rotate = 0, profit = 0, maxProfit = 0, minRotate = 0;
        for(int i=0; i<n; i++){
            totalCus += customers[i];
            rotate++;
            if(totalCus > 4){
                totalCus -= 4;
                onBoard += 4;
            }else{
                onBoard += totalCus;
                totalCus = 0;
            }
            getCurCost(onBoard, boardingCost, rotate, runningCost);
        }
        while(totalCus > 4){
            rotate++;
            if(totalCus > 4){
                totalCus -= 4;
                onBoard += totalCus;
                totalCus = 0;
            }
            getCurCost(onBoard, boardingCost, rotate, runningCost);
        }
        return res < 0 ? -1 : times;
    }



    public void  getCurCost(int onBoard, int boardignCost, int rotate, int runingCost){
        cost = onBoard * boardignCost - rotate * runingCost;
        if(cost > res){
            res = cost;
            times = rotate;
        }
    }


    public static void main(String args[]) throws IOException {
        _1599_MaximumProfitofOperatingWheel test = new _1599_MaximumProfitofOperatingWheel();
        int[] customers = {0,43,37,9,23,35,18,7,45,3,8,24,1,6,37,2,38,15,1,14,39,27,4,25,27,33,43,8,44,30,38,40,20,5,17,27,43,11,6,2,30,49,30,25,32,3,18,23,45,43,30,14,41,17,42,42,44,38,18,26,32,48,37,5,37,21,2,9,48,48,40,45,25,30,49,41,4,48,40,29,23,17,7,5,44,23,43,9,35,26,44,3,26,16,31,11,9,4,28,49,43,39,9,39,37,7,6,7,16,1,30,2,4,43,23,16,39,5,30,23,39,29,31,26,35,15,5,11,45,44,45,43,4,24,40,7,36,10,10,18,6,20,13,11,20,3,32,49,34,41,13,11,3,13,0,13,44,48,43,23,12,23,2};
        int boardingCost = 43;
        int runningCost = 54;
        test.minOperationsMaxProfit(customers, boardingCost, runningCost);
    }
}
