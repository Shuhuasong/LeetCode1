package BinarySearch.TwoDimension;

public class _1351_CountNegationNumbersInaSortedMatrix {
    //Time: O(n log m) Space: O(1)
    public int countNegatives(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int count = 0;
        for(int[] row : grid){
            int lo = 0, hi = row.length;
            while(lo < hi){
                int mid = lo + (hi-lo)/2;
                if(row[mid] >= 0){
                    lo = mid + 1;
                }else{
                    hi = mid;
                }
            }
            count += row.length - lo;
        }
        return count;
    }
}
