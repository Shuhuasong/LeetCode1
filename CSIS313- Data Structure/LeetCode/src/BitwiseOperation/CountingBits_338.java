package BitwiseOperation;

public class CountingBits_338 {
  /*  public int[] countBits(int num) {
        int[] counts = new int[num+1];
        int i=0;
        int j=0;
        while(i<=num){
            counts[j++] = Integer.bitCount(i);
            i++;
        }
        return counts;
    }

   */

    public int[] countBits(int num) {
        int[] mem = new int[num+1];
        mem[0] = 0;
        for(int i=1; i<=num; i++){
            mem[i] = mem[i/2] + i % 2;
        }
        return mem;
    }
}


/*
x/2 = y
when x is Odd number, # of set bits in x = 1 + # of set bits in y
when y is even number, # of set bits in x = # of bits in y
*/