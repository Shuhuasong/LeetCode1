package InterviewChallege.Amazon2020;

import java.io.IOException;
import java.util.*;

public class DisplayItem {

    static class PairInt{
        int relevance;
        int price;
        public PairInt(){ }
        public PairInt(int relevance, int price){
            this.relevance = relevance;
            this.price = price;
        }
    }

    public  DisplayItem(){ }



    public static ArrayList<String> displayItem(int numItems, HashMap<String, PairInt> items,
                                   int sortParam, int sortOrder, int itemPerPage, int pageNum){

        PriorityQueue<Map.Entry<String, PairInt>> pq;
        ArrayList<String> result = new ArrayList<>();
        //SortParam:  0-name, 1-relevance , 2-price
        //sortOrder: 0-ascending order, 1-decending order
     if(sortOrder==0){
         if(sortParam==1){
              pq = new PriorityQueue<>((a,b)->a.getValue().relevance-b.getValue().relevance);
         }else if(sortParam==2){
              pq = new PriorityQueue<>((a,b)->a.getValue().price-b.getValue().price);
         }else{
              pq = new PriorityQueue<>(((a, b) -> Integer.parseInt(a.getKey()) - Integer.parseInt(b.getKey())));
         }
     }
     else{
         if(sortParam==1){
              pq = new PriorityQueue<>((a,b)->b.getValue().relevance-a.getValue().relevance);
         }else if(sortParam==2){
              pq = new PriorityQueue<>((a,b)->b.getValue().price-a.getValue().price);
         }else{
              pq = new PriorityQueue<>(((a, b) -> Integer.parseInt(b.getKey()) - Integer.parseInt(a.getKey())));
         }
     }
        for(Map.Entry<String, PairInt> entry : items.entrySet()){
            //System.out.println("Test: " + entry.getKey() + " " + entry.getValue().relevance + " " + entry.getValue().price);
            pq.add(entry);
        }
        int num = pageNum * itemPerPage;
        while(!pq.isEmpty() && num > 0){
            pq.poll();
            num--;
        }
        int i = itemPerPage;
        while(!pq.isEmpty() && i>0){
            Map.Entry<String,PairInt> entry = pq.poll();
            System.out.println("Test: " + entry.getKey() + " " + entry.getValue().relevance + " " + entry.getValue().price);
            result.add(entry.getKey());
            i--;
        }
        return result;
    }

    public static void main(String args[]) throws IOException{
        DisplayItem display = new DisplayItem();
        int numItems = 3;
        HashMap<String, PairInt> items = new HashMap<>();
        items.put("item1", new PairInt(10, 15));
        items.put("item2", new PairInt(3, 4));
        items.put("item3", new PairInt(17, 8));
        items.put("item4", new PairInt(11, 9));
        items.put("item6", new PairInt(12, 7));
        int sortParam = 2;
        int sortOrder = 1;
        int ItemPerPage = 2;
        int pageNum = 1;
        ArrayList<String> ans  =  display.displayItem(numItems, items, sortParam, sortOrder, ItemPerPage, pageNum);

        for(String name : ans){
            System.out.print(name + " ");
        }
    }
}
