package BitwiseOperation;

public class CountingBits_338 {
    public int[] countBits(int num) {
        int[] counts = new int[num+1];
        int i=0;
        int j=0;
        while(i<=num){
            counts[j++] = Integer.bitCount(i);
            i++;
        }
        return counts;
    }
}
