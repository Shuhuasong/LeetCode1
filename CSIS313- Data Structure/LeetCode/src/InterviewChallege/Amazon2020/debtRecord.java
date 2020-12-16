package InterviewChallege.Amazon2020;

import java.io.IOException;
import java.util.*;

public class debtRecord {
    String borrower = "";
    String lender = "";
    int amount = 0;
    public debtRecord(){ }
    public  debtRecord(String borrower, String lender, int amount){
        this.borrower = borrower;
        this.lender = lender;
        this.amount = amount;
    }
}

class Debt{

    Debt(){}

    static Map<String, Integer> map = new HashMap<>();
   public static  List<String> minimumDebtMembers(List<debtRecord> records){
        int small = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
       for(debtRecord record : records){
           //borrower -
           //lender +
           String borrow = record.borrower;
           String lend = record.lender;
           int num = record.amount;
          // System.out.println(borrow + " " + lend + " " + num);
           map.put(borrow, map.getOrDefault(borrow, 0)-num);
           map.put(lend, map.getOrDefault(lend, 0)+num);
//           small = Math.min(small, map.get(borrow));
//           small = Math.min(small, map.get(lend));
           //System.out.println("small: " + small);
       }
       for(String name : map.keySet()){
           if(map.get(name)<small){
               small = map.get(name);
           }
       }
       for(String name : map.keySet()) {
           if (map.get(name) == small) {
               res.add(name);
           }
       }
       Collections.sort(res);
       return res;
    }

    public static void main(String args[]) throws IOException {
        Debt debt = new Debt();

        List<debtRecord> list = new ArrayList<>();
        list.add(new debtRecord("Alex", "Blake", 2));
        list.add(new debtRecord("Blake", "Alex", 2));
        list.add(new debtRecord("Casey", "Alex", 5));
        list.add(new debtRecord("Blake", "Casey", 7));
        list.add(new debtRecord("Alex", "Blake", 4));
        list.add(new debtRecord("Alex", "Casey", 4));
        List<String> result = new ArrayList<>();
        result = debt.minimumDebtMembers(list);
        for(String s : result){
            System.out.println(s);
        }
    }

}
