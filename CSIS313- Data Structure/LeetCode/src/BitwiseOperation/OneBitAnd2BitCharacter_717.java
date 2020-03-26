package BitwiseOperation;

public class OneBitAnd2BitCharacter_717 {
    public boolean isOneBitCharacter(int[] bits) {
        int idx = 0;
        while(idx < bits.length){
            if(bits[idx]==1){
                idx = idx + 2;
            }else{
                if(idx==bits.length-1) return true;
                idx++;
            }
        }
        return false;
    }
}
