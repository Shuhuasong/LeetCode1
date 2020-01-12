package BitwiseOperation;

public class MiniFlipaOrbEqualc {
   /* public int minFlips(int a, int b, int c) {
        int res = 0, ab = a|b, equal = ab^c;
        for(int i=0; i<31; i++){
            int mask = 1<<i;
            if((equal & mask)>0){
                res += (ab & mask) > (c&mask) && (a & mask) == (b & mask) ? 2: 1;
                //ab^=mask;
            }
        }
        return res;
    }

    */

    public int minFlips(int a, int b, int c) {
        int res = 0;
        while(a != 0 || b != 0 || c != 0){
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;
            if(bitC==0) res = (bitA + bitB);
            else if((bitA | bitB) == 0) res++;
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return res;
    }

}
