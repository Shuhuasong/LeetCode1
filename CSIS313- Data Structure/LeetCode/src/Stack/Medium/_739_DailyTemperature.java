package Stack.Medium;

import java.util.Stack;

public class _739_DailyTemperature {

    //Solution 1: Brute Force
    //Time: O(n^2)  Space: O(1)
    public int[] dailyTemperatures(int[] T) {
        if(T==null || T.length==0) return new int[0];
        int[] res = new int[T.length];
        for(int i=0; i<T.length-1; i++){
            for(int j=i+1; j<T.length; j++){
                if(T[j] > T[i]){
                    res[i] = j-i;
                    break;
                    // System.out.println(T[i] + " " + T[j]);
                }
            }
        }
        return res;
    }



    //Solution 2: Using Stack
    //Time: O(n)  Space: O(n)
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<T.length; i++){
            while(!s.isEmpty() && T[i] > T[s.peek()]){
                int idx = s.pop();
                res[idx] = i - idx;
            }
            s.push(i);
        }
        return res;
    }


    //Solution 3: Changing Stack to array
    //Time: O(n)  Space: O(n)
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        int[] s = new int[T.length];
        int top = -1;
        for(int i=0; i<T.length; i++){
            while(top >= 0 && T[i] > T[s[top]]){
                int idx = s[top--];
                res[idx] = i - idx;
            }
            s[++top] = i;
        }
        return res;
    }
}
