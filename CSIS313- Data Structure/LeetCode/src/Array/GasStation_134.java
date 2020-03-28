package Array;

public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length != cost.length) return -1;

        int total = 0; // total_gas - total_cost
        int curr = 0; //the current gas left
        int start = 0; //start point

        for(int i=0; i<cost.length; i++){
            curr += gas[i]-cost[i];

            if(curr < 0){
                start = i+1;
                curr = 0;
            }
            total += gas[i] - cost[i];
        }

        //if total gas  >= 0, then we can go the whole circle
        return total >= 0 ? start : -1;
    }
}
