package Math;

public class _504_Base7 {
     /*  public String convertToBase7(int num) {
       if(num==0) return "0";

       String res = "";
       boolean isNegative = num < 0;
       int abs = Math.abs(num);
       int rem = 0;
       while(abs > 0){
           rem = abs % 7;
           res = rem + res;
           abs = abs/7;
       }
       if(isNegative){
           res = "-" + res;
       }
        return res;
    }
    */

    public String convertToBase7(int num) {
        if(num < 0) return "-"+ convertToBase7(-num);
        if(num<7) return Integer.toString(num);
        return convertToBase7(num/7)+convertToBase7(num%7);
    }

}
