package HashMap;

import java.util.HashMap;
import java.util.Map;

public class _166_FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        long r = n%d;
        StringBuilder sb = new StringBuilder();

        if(n>0 && numerator > 0 ^ denominator >0) sb.append("-");
        sb.append(n/d);

        if(r>0) sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(r>0){
            if(map.containsKey(r)){
                sb.insert(map.get(r), "(");
                sb.append(")");
                break;
            }else{
                map.put(r, sb.length());
                r *= 10;
                sb.append(r/d);
                r = r%d;
            }
        }
        return sb.toString();
    }
}
