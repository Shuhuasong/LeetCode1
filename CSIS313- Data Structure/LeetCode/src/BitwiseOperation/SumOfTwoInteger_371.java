package BitwiseOperation;

public class SumOfTwoInteger_371 {
    public int getSum(int a, int b) {
        while(b!=0){
            int sum = a ^ b;
            int carry = (a&b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}

/*
  0     1     0       1
+ 0     0     1       1
  0     0     1      10

  Sum of two bits can be obtained by performing XOR (^) of the two bits. Carry bit can be obtained by performing AND (&) of two bits.
  https://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-operators/
*/

