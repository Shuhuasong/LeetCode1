package Array.Medium;

public class _1395_CountNumberOfTeams {
    //Time: O(n^2)  Space: O(1)
    public int numTeams(int[] rating) {
        int n = rating.length;
        int res = 0;
        for(int j=0; j<n; j++){
            int leftSmaller = 0, leftLarger = 0;
            int rightSmaller = 0, rightLarger = 0;
            for(int i=0; i<j; i++){
                if(rating[i]<rating[j]) leftSmaller++;
                else if(rating[i]>rating[j]) leftLarger++;
            }

            for(int k=j+1; k<n; k++){
                if(rating[j] < rating[k]) rightLarger++;
                else if(rating[j] > rating[k]) rightSmaller++;
            }
            res += leftSmaller*rightLarger + leftLarger*rightSmaller;
        }
        return res;
    }

    /*
    //Time: O(n^3) Space: O(1)
    public int numTeams(int[] rating) {
        int n = rating.length;
        int res = 0;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    if((rating[i]<rating[j] && rating[j]<rating[k]) ||
                       (rating[i]>rating[j] && rating[j]>rating[k])){
                        res++;
                    }
                }
            }
        }
        return res;
    }
     */
}
