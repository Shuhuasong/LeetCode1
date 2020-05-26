package SlicingWindow;

public class _1234_ReplaceTheSubstringforBalancedString {
    public int balancedString(String s) {
        int n = s.length(), res = n, i=0, k = n/4;
        int[] count = new int[128];

        for(int j=0; j<n; j++){
            count[s.charAt(j)]++;
        }
        for(int r=0; r<n; r++){
            count[s.charAt(r)]--;
            while(i<n && count['Q'] <= k && count['W'] <= k && count['E'] <= k && count['R'] <= k){
                res = Math.min(res, r-i+1);
                count[s.charAt(i++)]++;
            }
        }
        return res;
    }
}
