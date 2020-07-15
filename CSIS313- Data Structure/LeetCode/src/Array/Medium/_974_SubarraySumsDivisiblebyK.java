package Array.Medium;

public class _974_SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] A, int K) {
        int[] count = new int[K]; // can get 0-K reminder
        count[0] = 1;
        int sum = 0;
        int res = 0;
        for (int num : A) {
            sum += num;
            int r = (sum % K + K) % K;
            res += count[r];
            count[r]++;
        }
        return res;
    }
}

/*
We calculate all possible r's and map them to their counts, map[r] = count, there are two situations:

r != 0, then count * (count - 1) / 2 subarrays found
r == 0, the sum itself is divisible by k, thencount subarrays found
Please note that when calculate sum % K for sum < 0, we keep adding K to sum until sum is above 0 then mod K.
               intput
          R    4  5  0  -2  -3  1
reminder  4  | 4 |
          4  | 9    |
          4  | 9       |
          2  | 7            |
          4  | 4               |
          0  | 5                   |
             | preSum
*/
