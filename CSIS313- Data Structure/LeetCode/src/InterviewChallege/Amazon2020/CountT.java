package InterviewChallege.Amazon2020;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountT {
    public CountT(){}

    public int nCr(int n, int r){
        return fact(n)/(fact(r)*fact(n-r));
    }
    public int fact(int n){
        int res = 1;
        for(int i=2; i<=n; i++){
            res *= i;
        }
        return res;
    }

    public int countTeam(int num, int[] skills, int minAssociates, int minLevel, int maxLevel){
      List<Integer> list = new ArrayList<>();
      for(int s : skills){
          if(s>=minLevel && s <= maxLevel){
              list.add(s);
          }
       }
//      for(int a : list){
//          System.out.print(a + " ");
//      }
      System.out.println();
      int size = list.size();
      int res = 0;
      if(size < minAssociates) return res;
      for(int i=minAssociates; i<=size; i++){
          res += nCr(size, i);
          //System.out.println(  " res:  " + res);
      }
      return res;
    }
    public static void main(String args[]) throws IOException{
        CountT count = new CountT();
        int num = 6;
        int[] skills = {12, 4, 6, 13, 5, 10};
        int minAsso = 3;
        int minLevel = 4;
        int maxLevel = 10;
        int result = count.countTeam(num, skills, minAsso, minLevel, maxLevel);
        System.out.println("result: "+result);
    }
}
