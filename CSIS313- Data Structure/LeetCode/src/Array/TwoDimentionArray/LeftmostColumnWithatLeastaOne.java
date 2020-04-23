package Array.TwoDimentionArray;

import java.util.List;

public class LeftmostColumnWithatLeastaOne {
/*    interface BinaryMatrix {
      public int get(int row, int col) {}
      public List<Integer> dimensions {}
  };

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int rows = dim.get(0);
        int cols = dim.get(1);
        if(rows==0 || cols==0) return -1;
        int res = -1;
        int r = 0, c = cols-1;
        while(r < rows && c >=0){
            if(binaryMatrix.get(r,c)==1){
                res = c;
                c--;
            }else{
                r++;
            }
        }
        return res;
    }

 */
}


/*

A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
BinaryMatrix.dimensions() returns a list of 2 elements [rows, cols], which means the matrix is rows * cols.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
 */