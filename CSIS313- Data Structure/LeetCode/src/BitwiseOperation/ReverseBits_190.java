package BitwiseOperation;

import java.util.ArrayList;
import java.util.List;

public class ReverseBits_190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        //return Integer.reverse(n);
        int times = 32;
        List<Integer> list = new ArrayList<>();
        while(times>0){
            int t = n & 1;
            list.add(t); // list =  reverse integer
            n = n >> 1;
            times--;
        }

        int res = 0;   //rebuilt the list
        for(int i=0; i<list.size(); i++){
            res = res << 1;
            res = (res | list.get(i));
        }
        return res;
    }
}
