package Array;

public class NumOfLinesToWriteString_806 {
    //Time: O(n) Space: O(1)
    //run: 0ms (100%)
    public int[] numberOfLines(int[] widths, String S) {
        int[] ans = new int[2];
        int numLines = 1;
        int totalWid = 0;
        for(char c : S.toCharArray()){
            int perWid = widths[c - 'a'];
            if(totalWid+perWid > 100){
                numLines++;
                totalWid = 0;
            }
            totalWid += perWid;
        }
        ans[0] = numLines;
        ans[1] = totalWid;
        return ans;
    }
}
