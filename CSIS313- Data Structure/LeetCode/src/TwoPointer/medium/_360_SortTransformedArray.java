package TwoPointer.medium;

public class _360_SortTransformedArray {
    //Time: O(n) Space: O(n)
    //f(x) = ax^2 + bx + c
    int a, b, c;
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        int n = nums.length, i = 0, j = n-1;
        int[] res = new int[n];
        int idx = (a >= 0) ? n-1 : 0;//when a>=0, index start from n-1, otherwise, start from 0
        while (i <= j) {
            if (a >= 0) { //assign the value for res from end
                res[idx--] = cal(nums[i]) > cal(nums[j]) ? cal(nums[i++]) : cal(nums[j--]);
            } else {    //assign the value for res from begining
                res[idx++] = cal(nums[i]) < cal(nums[j]) ? cal(nums[i++]) : cal(nums[j--]);
            }
        }
        return res;
    }

    public int cal(int x){
        return a * x * x + b * x + c;
    }

}
