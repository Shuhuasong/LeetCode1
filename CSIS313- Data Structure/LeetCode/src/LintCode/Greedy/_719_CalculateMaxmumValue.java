package LintCode.Greedy;

/*gready's algorithm idea is :
    at the current moment, take the most convenient, best option
* */

public class _719_CalculateMaxmumValue {
    public int calcMaxValue(String str) {
        // write your code here
        if(str==null || str.length()==0){
            return 0;
        }
        if(str.length()==1) return str.charAt(0)-'0';
        int result = str.charAt(0)-'0';
        System.out.println(result);
        for(int i=1; i<str.length(); i++){
            int val = str.charAt(i) - '0';
            result = Math.max(result * val, result + val);
            System.out.println(result);
        }
        return result;
    }
}
