package InterviewChallege.Amazon2020;

import java.io.IOException;
import java.util.*;

public class SecretFruitList {

    public SecretFruitList(){}

    public int matchResult(List<List<String>> codeList, List<String> shoppingCart) {
        Map<String, List<Integer>> indexDictionary = new HashMap<>();
        for (int i=0; i<shoppingCart.size(); i++) {
            String s = shoppingCart.get(i);
            if (!indexDictionary.containsKey(s)) {
                indexDictionary.put(s, new ArrayList<Integer>());
            }
            indexDictionary.get(s).add(i);
        }

        int ans = 0;
        int minIndex = -1;
        for (List<String> code: codeList) {
            for (String c: code) {
                System.out.println(c);
                if (c.equals("anything")) {
                    minIndex++;
                    continue;
                }
                ans = binarySearch(c, indexDictionary, minIndex);
                System.out.println(ans);
                if (ans == -1) {
                    return 0;
                } else {
                    minIndex = ans;
                }
            }
        }

        return 1;
    }

    private int binarySearch(String code, Map<String, List<Integer>> indexMap, int target) {
        if (!indexMap.containsKey(code)) {
            System.out.println("don't find "+code);
            return -1;
        }

        List<Integer> list = indexMap.get(code);
        int left = 0;
        int right = list.size()-1;

        while (left <= right) {
            int mid = left+(right-left)/2;

            if (list.get(mid) > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return (left>=list.size())?-1:left;
    }

    public static void main(String[] args) {
        SecretFruitList test = new SecretFruitList();

        List<List<String>> codeList = new LinkedList<>();
        List<String> code1 = new ArrayList<>();
        code1.add("apple");
        code1.add("apple");

        List<String> code2 = new ArrayList<>();
        code2.add("banana");
        code2.add("anything");
        code2.add("banana");

        codeList.add(code1);
        codeList.add(code2);


        List<String> shoppingCart = new ArrayList<>();
        shoppingCart.add("orange");
        shoppingCart.add("apple");
        shoppingCart.add("apple");
        shoppingCart.add("banada");
        shoppingCart.add("orange");
        shoppingCart.add("banana");


        System.out.println(test.matchResult(codeList, shoppingCart));
    }

//https://leetcode.com/discuss/interview-question/762546/amazon-oa-2020-amazon-fresh-promotion


 /*   public boolean matchSecretLists(List<List<String>> secretFruitList, List<String> customerPurchasedList) {
     if(secretFruitList.size()==0) return true;
     Map<String, Integer> map = new HashMap<>();
     for(String fruit : customerPurchasedList){
         map.put(fruit, map.getOrDefault(fruit,0)+1);
     }
     boolean valid = true;
     for(List<String> list : secretFruitList){
         for(String fruit : list){
             if(map.containsKey(fruit)){
                 map.put(fruit, map.get(fruit)-1);
                 if(map.get(fruit)==0){
                     map.remove(fruit);
                 }
             }else if(fruit.equals("anything")){
                 if(map.size() < 1) valid = false;
                 else
                     continue;
             }
             else{
                 valid = false;
             }
          }
       }
     return valid;
    }

  */

    /*
     private static int isWinner(String[][] codeList,String[] shoppingCart){
        //check zero length...
        if(codeList == null || codeList.length == 0)
            return 1;
        if(shoppingCart == null || shoppingCart.length == 0)
            return 0;
        int i=0,j=0;
        for(int k=0;k<shoppingCart.length;k++) {
            //when match success
            if(codeList[i][j].equals(shoppingCart[k]) || codeList[i][j].equals("anything")) {
                j++;
                if(j == codeList[i].length) {
                    i++;
                    j=0;
                }
                if(i == codeList.length)
                    return 1;
            }else {
                //when match failed, k and j both go back.
                k-=j;
                j=0;
            }
        }
        return 0;
    }
     */


 /*   public static void main(String args[]) throws IOException{
        SecretFruitList secFruit = new SecretFruitList();
        List<List<String>>  secretFruit = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("watermelon");
        list1.add("anything");
        list1.add("mongo");
//        ArrayList<String> list2 = new ArrayList<>();
//        list2.add("watermelon");
//        list2.add("mongo");
        secretFruit.add(list1);
        //secretFruit.add(list2);
        ArrayList<String> custList = new ArrayList<>();
        custList.add("watermelon");
        custList.add("orange");
//        custList.add("mongo");
//        custList.add("strawberry");
//
        custList.add("mongo");

        boolean valid = secFruit.matchSecretLists(secretFruit ,  custList);
        System.out.println("vallid: " + valid);
    }

  */

}
