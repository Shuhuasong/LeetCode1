package Array;


//0 ms, 36.1MB , faster than 100% submission
// Time Complexity O(n^2), Space Complexity O(1)
public class RotateImage48 {
  /*  public void rotate(int[][] matrix) {

        int rows =  matrix.length;//number of rows
        int cols = matrix[0].length;//number of columns
        int[][]  newMatrix = new int[rows][cols];
        for(int k=0; k<rows; k++){
            newMatrix[k] = matrix[k].clone();
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<rows; j++){
                matrix[j][rows-i-1] = newMatrix[i][j];
            }
        }
    }

   */

    //Time:O(n^2) Space: O(1)
    //run: 0ms (100%)
    public void rotate(int[][] matrix) {
        //non constant space
        int n = matrix.length;
        for(int i=0; i< n; i++){
            for(int j=i; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}
