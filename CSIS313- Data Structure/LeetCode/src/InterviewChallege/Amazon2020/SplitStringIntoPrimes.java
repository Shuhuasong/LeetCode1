package InterviewChallege.Amazon2020;

import java.io.IOException;
import java.util.*;

public class SplitStringIntoPrimes {

    public SplitStringIntoPrimes(){ }

    static Set<Integer> primeNumSet = new HashSet<>();

    public static int strToPrimes(String inputStr){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findPrime(inputStr, list , result);
        return result.size();
    }

    public static void findPrime(String preString, List<Integer> list ,List<List<Integer>> result){
        if(preString.length() == 0){
            result.add(new ArrayList<>(list));
            System.out.println(result.toString());
            return;
        }

        for(int i=0; i<preString.length(); i++){
            String curStr = preString.substring(0, i+1);
            System.out.print(curStr + " ");
            int num = Integer.parseInt(curStr);
            boolean isPrime = checkPrime(num);
            if(isPrime && num<1000){
                list.add(num);
                findPrime(preString.substring(i+1), list, result);
                list.remove(list.size()-1);
            }
        }
    }

    public static boolean checkPrime(int num){
        if(primeNumSet.contains(num)) return true;
        boolean isPrime = isPrimeNum(num);
        if(isPrime) primeNumSet.add(num);
        return isPrime;
    }
    public static boolean isPrimeNum(int num){

        if(num < 2) return false;
        if(num == 2) return true;
        if(num%2 == 0) return false;
        for(int i=3; i<=num/2; i=i+2){
            if(num % i==0) return false;
        }
        return true;
    }
  /*  static int[] primes = sieve(1001);

    public int getWays(String s){
       int result = solve(s, primes);
       return result;
    }
    static int mod = (int)1e9+7;
    public static int solve(String s, int[] primes){

        int n = s.length();
        //dp[i] : the number of ways to split till i-th digit into primes
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            if(s.charAt(i-1) != '0' && primes[Integer.parseInt(s.substring(i-1, 1))]==1){
                dp[i] = dp[i-1];
            }
            if(i-2 >=0 && s.charAt(i-2) != '0' && primes[Integer.parseInt(s.substring(i-2, 2))]==1){
                dp[i] = (dp[i]+dp[i-2]) % mod;
            }
            if (i - 3 >= 0 && s.charAt(i - 3) != '0' && primes[Integer.parseInt(s.substring(i - 3, 3))] == 1) {
                dp[i] = (dp[i]+dp[i-3]) % mod;
            }
        }
        return dp[n];
    }

    public static int[] sieve(int n){
        int[] p = new int[n];
        Arrays.fill(p, 1);
        p[0] = p[1] = 0;
        for(int i=2; i<=1000; i++){
            if(p[i] == 0) continue;
            for(int j=i*i; j<=1000; j=j+i){
                p[j] = 0;
            }
        }
        return p;
    }

   */

    public static void main(String args[]) throws IOException {
        SplitStringIntoPrimes strPrime = new SplitStringIntoPrimes();
        String inputString = "11373";
        int result = strPrime.strToPrimes(inputString);
        //int result = strPrime.getWays("1137");
        System.out.println("result: " + result);
    }
}

