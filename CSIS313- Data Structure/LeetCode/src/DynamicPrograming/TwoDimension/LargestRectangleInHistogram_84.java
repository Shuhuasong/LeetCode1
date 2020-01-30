package DynamicPrograming.TwoDimension;

import java.util.Stack;

public class LargestRectangleInHistogram_84 {
    //Time: O(n) Space: O(n)
    //run time: 8ms (84%)
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0) return 0;

        int n = heights.length;
        int max = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int curIndex = 0;

        while(curIndex < n)  {
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[curIndex]) {
                max = Math.max(max, heights[stack.pop()] * (curIndex-stack.peek()-1));
            }
            stack.push(curIndex++);
        }

        while(stack.peek() != -1){
            max = Math.max(max, heights[stack.pop()]   * (n- stack.peek() -1));
        }
        return max;
    }
}
