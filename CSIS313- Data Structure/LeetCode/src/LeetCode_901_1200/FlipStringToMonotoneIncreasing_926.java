package LeetCode_901_1200;

public class FlipStringToMonotoneIncreasing_926 {

    //run time: 5ms (52.88%)
    //Time Complexity: O(n), Space Complexity: O(1)
    public int minFlipsMonoIncr(String S) {
        if(S == null || S.length()==0) return 0;
        int ones = 0;
        int flip = 0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)=='0'){
                if(ones!=0){
                    flip++;
                }else continue;
            }else{
                ones++;
            }
            if(flip>ones){
                flip = ones;
            }
        }
        return flip;
    }
}
