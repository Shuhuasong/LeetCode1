package InterviewChallege.Amazon2020;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class RemoveProductID {

    RemoveProductID(){ }

    public static int removeProdIn(int num, int[] ids, int rem){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int id  :   ids){
            map.put(id, map.getOrDefault(id, 0)+1);
        }
        int n = ids.length;
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->
                             a.getValue()-b.getValue());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
        }
        while(rem > 0 && !pq.isEmpty()){
            rem = rem - pq.peek().getValue();
            if(rem>0){
                pq.poll();
            }
        }
        return pq.size();
    }

    /*
    public static int removeProdIn(int num, int[] ids, int rem){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int id  :   ids){
            map.put(id, map.getOrDefault(id, 0)+1);
        }
        int n = ids.length;
        if(rem==0) return map.size();
        if(rem==num) return 0;
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while(i<n){
            while(rem>0 && !stack.isEmpty() && stack.peek() > ids[i]){
                stack.pop();
                rem--;
            }
            stack.push(ids[i++]);
        }
        while(rem-->0) stack.pop();
        Map<Integer, Integer> res = new HashMap<>();
        while(!stack.isEmpty()){
            int val = stack.pop();
            res.put(val, res.getOrDefault(val, 0)+1);
        }
        return res.size();
    }

     */

    public static void main(String args[]) throws IOException{
        RemoveProductID remProduct = new RemoveProductID();
        int num = 3;
        int[] ids = {5,5,4};
        int rem = 2;
        int result = remProduct.removeProdIn(num, ids, rem);
        System.out.print("result: " + result);
    }
}
