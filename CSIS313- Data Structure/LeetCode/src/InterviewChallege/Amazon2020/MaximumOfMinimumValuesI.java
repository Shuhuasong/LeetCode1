package InterviewChallege.Amazon2020;

public class MaximumOfMinimumValuesI {

       public MaximumOfMinimumValuesI(){}

       static int max = Integer.MIN_VALUE;

       public static int maxPathScore(int[][] matrix) {
       if(matrix==null || matrix.length==0 || matrix[0].length==0){
           return 0;
       }
       int min = Integer.MAX_VALUE;
       helper(matrix, min, 0, 0);
       return max;
       }

       public static void helper(int[][] matrix, int min, int row, int col){
           if(row >= matrix.length || col >= matrix[0].length){
               return;
           }
           if(row==matrix.length-1 && col == matrix[0].length-1){
               max = Math.max(min, max);
               return;
           }
           min = Math.min(matrix[row][col], min);
           helper(matrix, min, row + 1, col);
           helper(matrix, min, row, col + 1);
       }

    public static void main(String[] args){
        MaximumOfMinimumValuesI maxi = new MaximumOfMinimumValuesI();
        int[][] matrix = {{7,5,3},{2,0,9},{4,5,9}};
        int result =  maxi.maxPathScore(matrix);
        System.out.println("result: " + result);
    }
}
