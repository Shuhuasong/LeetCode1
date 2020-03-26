package DynamicPrograming.Tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class RecursionAndDynamic {
    //Question1: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
    //steps at a time. Implement a method to count how many possible ways the child can run up the
    //stairs.
    //Solution1: Brute Force
    //Time: O(n^3)
    int countWays1(int n){
        if(n < 0) return 0;
        else if(n==0) return 1;
        else{
           return countWays1(n-1)+countWays1(n-2)+countWays1(n-3);
        }
    }

    //Solution2: Memorization Solution
    int countWays(int n){
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    private int countWays(int n, int[] memo){
        if(n<0) return 0;
        else if(n==0) return 1;
        else if(memo[n]>-1) return memo[n];
        else{
            memo[n]=countWays(n-1, memo)+countWays(n-2, memo)+countWays(n-3,memo);
            return memo[n];
        }
    }
    /*
    you get to just n 37, the result has already overflowed. Using a long
      will delay, but not completely solve, this issue.
     */



    //Question 2:
 /*   Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
    The robot can only move in two directions, right and down, but certain cells are "off limits" such that
    the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
    the bottom right.
  */
   //Solution 1: Brute Force
    //Time: O(2^(r+c)) Space: O(n^2)
    ArrayList<Point> getPath1(boolean[][] grid){
        if(grid == null || grid.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        if(getPath1(grid, grid.length-1, grid[0].length-1, path)){
            return path;
        }
        return null;
    }

    private boolean getPath1(boolean[][] grid, int row, int col, ArrayList<Point> path) {
        if(row < 0 || col < 0 || !grid[row][row]) return false;
        boolean isAtOrigin = (row==0 && col==0);
        if(isAtOrigin || getPath1(grid,row, col-1, path) || getPath1(grid, row-1, col, path)){
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }


    //Solution 2: findig duplicate work point(r-1)(c-1)

    ArrayList<Point> getPath(boolean[][] grid){
        if(grid==null || grid.length==0) return null;
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failPoints = new HashSet<>();
        if(getPath(grid, grid.length-1, grid[0].length-1, path, failPoints)){
            return path;
        }
        return null;
    }

    private boolean getPath(boolean[][] grid, int row, int col, ArrayList<Point> path, HashSet<Point> failPoints) {
        //if out of bound or not available, return
        if(row < 0 || col < 0 || !grid[row][col]) return false;
        Point p = new Point(row, col);
        //if we have already visited this cell, return
        if(failPoints.contains(p)) return false;
        boolean isAtOrigin = (row==0&& col==0);
        if(isAtOrigin || getPath(grid, row, col-1, path, failPoints)||
                getPath(grid, row-1, col, path, failPoints)){
            path.add(p);
            return true;
        }
        failPoints.add(p);
        return false;
    }

}
