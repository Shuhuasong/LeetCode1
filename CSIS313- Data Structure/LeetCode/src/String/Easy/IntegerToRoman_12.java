package String.Easy;


/*
 58 > 50 L      1994 > 1000 M
  8 > 5  V       994 > 900  CM
  3 > 1  I       94  > 90   XC
  2 > 1  I        4  = 4    IV
  2 > 1  I
  LVIII          MCMXCIV
 */
//run time:4ms (76%)
//Time Complexity: O(n)
//Space Complexity: O(n)
public class IntegerToRoman_12 {
    public String intToRoman(int num) {
        int[] values = {1000,  900, 500, 400,  100,  90,  50,  40,   10,   9,    5,    4,   1 };
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<values.length; i++){
//            while(num >=values[i]){
//                num -= values[i];
//                sb.append(strs[i]);
//            }
            if(num >= values[i]){
                sb.append(strs[i]);
                num -= values[i];
            }else {
                i++;
            }
        }
        return sb.toString();
    }
}
