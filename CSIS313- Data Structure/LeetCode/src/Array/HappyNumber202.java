package Array;

import java.util.HashSet;

public class HappyNumber202 {

    public boolean isHappy(int n) {
       HashSet<Integer>  seem = new HashSet<Integer>();
       /* String num = Integer.toString(n);
        while(n!= 1){
            n = 0;
           for(int i=0; i<num.length(); i++) {
               n += (Integer.parseInt(num.substring(i, i + 1))) * (Integer.parseInt(num.substring(i, i + 1)));
             }
               if(seem.contains(n)){
                   return false;
               }else{
                   seem.add(n);
               }

           num = Integer.toString(n);
        }


        return false;
        */

       int num = getSum(n);
       while(num != 1 && seem.add(num)){
           num = getSum(num);
       }
       return num==1;
    }

    public int getSum(int n){
        int sum = 0;
        while(n>0){
            sum += (n%10) * (n%10);
            n /= 10;
        }
        return sum;
    }

}
