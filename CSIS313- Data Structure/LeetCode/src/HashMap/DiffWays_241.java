package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Time Complexity: O(n)
//Space Complexity: O(2^h)
public class DiffWays_241 {

    public static List<Integer> diffWaystoCompute(String input){
        Map<String, List<Integer>> map = new HashMap<>();
        return ways(input, map);
    }


    private static List<Integer> ways(String input, Map<String, List<Integer>> map) {

        if(map.containsKey(input)) return map.get(input);

        List<Integer> list = new ArrayList<>();
        int num = 0;
        boolean findOp = false;

        for(int i=0; i<input.length(); i++){
            if(isOperator(input.charAt(i))){
                List<Integer>  l = ways(input.substring(0, i), map);
                List<Integer>  r = ways(input.substring(i+1), map);
                compute(list, l , r, input.charAt(i));
                findOp = true;
            }
            if(!findOp){
                num = (num * 10) + (input.charAt(i) -'0');
            }
        }

        if(!findOp)
            list.add(num);

        map.put(input, list);
        return list;
    }


   public static void compute(List<Integer> list, List<Integer> l, List<Integer> r, char op){
        for(int a : l){
            for(int b : r){
                list.add(calculate( a,  b, op));
            }
        }
   }

   public static int calculate(int a, int b, char op){
        switch(op){
            case '+' : return a+b;
            case '_' : return a-b;
            case '*' : return a*b;
        }
        return 0;
   }

    public static boolean isOperator(char c){
        return ( c=='+' || c=='-' || c=='*');
    }

    public static void  main(String[] args){
        String a = "2-1-1";
        System.out.println(diffWaystoCompute(a));

    }
}




/*class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> map = new HashMap<>();
        return diffWaysToCompute(input, map);
    }

    public List<Integer> diffWaysToCompute(String input, Map<String, List<Integer>> map) {
        if(map.containsKey(input))
            return map.get(input);
        List<Integer> list = new ArrayList<>();
        int num = 0;
        boolean symbolFound = false;
        for(int i = 0; i < input.length(); i++) {
            if(isSymbol(input.charAt(i))) {
                List<Integer> list1 = diffWaysToCompute(input.substring(0, i), map);
                List<Integer> list2 = diffWaysToCompute(input.substring(i + 1), map);
                compute(list, list1, list2, input.charAt(i));
                symbolFound = true;
            }
            if(!symbolFound)
                num = (num * 10) + (input.charAt(i) - '0');
        }
        if(!symbolFound)
            list.add(num);
        map.put(input, list);
        return list;
    }

    private void compute(List<Integer> list, List<Integer> list1, List<Integer> list2, char symbol) {
        for(int i : list1) {
            for(int j : list2) {
                list.add(compute(i, j, symbol));
            }
        }
    }

    private int compute(int a, int b, char symbol) {
        switch(symbol) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return 0;
    }

    private boolean isSymbol(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}

 */
