package InterviewChallege;

import java.util.List;

/*
give an array :
outfits = { 2, 3, 5, 1, 1, 2, 1}
target = 5;
choose the as many number as possible(maxmim) in array to have the sum=5
eg. {2,3}, {5}, { 1, 1, 2, 1}
 */
public class MaxmumOutFits {
    public int getMaxMumOutFit(List<Integer> outfits, int money){
        if(outfits == null || outfits.size()==0) return 0;
        int n = outfits.size();
        int localSum = 0;
        int slow = 0;
        int max = 0;
        for(int fast=0; fast<=n; fast++){
            if(fast == n) return Math.max(fast-slow, max);

            localSum  = localSum + outfits.get(fast);
            while(localSum > money){
                localSum = localSum-outfits.get(slow);
                slow++;
            }
            max = Math.max(fast-slow, max);
        }
        return max;
    }
}
