package BitwiseOperation;

public class NumberOf1Bits_191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
     /*   int res = 0;
        for(int i=0; i<32; i++){
            res += n & 1;
            n >>= 1; //move one bit on the right side
        }
        return res;
        */
        return Integer.bitCount(n);
    }
}
