package String.Easy;

public class RomeantoInteger_13 {

    //Time Complexity: O(n)
    //Space Complexity:O(1)
    /* rule: if numLeft < numRight => numRight-numLeft
       res: 1
       IV : 4
       V - I = 5-1 = 4
       res = res + V-I - res = 1 + 5 - 1  - 1 = 5 -1
     */
    //run time: 5ms (59%)  45.1 MB
     public int romanToInt(String s) {


     /*   if(s==null && s.length()==0) return 0;
        int res = toNumber(s.charAt(0));
        for(int i=1; i<s.length(); i++){

            if(toNumber(s.charAt(i))>toNumber(s.charAt(i-1))){
                res += toNumber(s.charAt(i)) - 2*toNumber(s.charAt(i-1));
            }else{
                res += toNumber(s.charAt(i));
            }


        }
        return res;
    } */

    // 4ms (71%)
         int n = s.length();
         int i = 0;
         int num = 0;
         while (i < n) {
             if ((i + 1) < n && toNumber(s.charAt(i)) < toNumber(s.charAt(i + 1))) {
                num += toNumber(s.charAt(i + 1)) - toNumber(s.charAt(i));
                i = i+2;
                continue;
             }
             else{
                 num += toNumber(s.charAt(i + 1));
                 i++;
             }
         }
         return num;

     }

    public  int toNumber(char c){
        int res = 0;
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return res;
    }



    //run time: 4ms (71%)
 /*   public int romanToInt(String s) {
        int sum = 0, preNum = 0;

        for (int i = s.length()-1; i>=0; i--) {
            int num =0;
            char c = s.charAt(i);
            switch(c){
                case 'I': num =  1;
                case 'V': num = 5;
                case 'X': num = 10;
                case 'L': num = 50;
                case 'C': num = 100;
                case 'D': num = 500;
                case 'M': num = 1000;
            }

            if(num>=preNum) { sum += num;}
            else { sum -= num; }
            preNum = num;
        }
        return sum;
    }

  */


}










/*

 */