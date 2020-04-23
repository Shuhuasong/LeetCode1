package Stack.Medium;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunction_636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>(); //store id
        //decomprise logs "0:start:0"
        String[] S = logs.get(0).split(":");
        stack.push(Integer.valueOf(S[0])); //push id
        int preTime = Integer.valueOf(S[2]); //start time
        //log one by one
        for(int i=1; i<logs.size(); i++){
            String[] s = logs.get(i).split(":");
            int id = Integer.valueOf(s[0]);
            String status = s[1];
            int time = Integer.valueOf(s[2]);
            //start vs end
            if(status.equals("start")){
                if(!stack.isEmpty()){
                    int index = stack.peek();
                    res[index] += time-preTime;
                }
                stack.push(id);
                preTime = time;
            }
            else{
                int index = stack.pop();
                res[index] += time-preTime+1;
                preTime = time+1;
            }
        }
        return res;
    }
}


/*
sigle thread:  first in last out --> stack
start ? end --> deal with seperate
*/