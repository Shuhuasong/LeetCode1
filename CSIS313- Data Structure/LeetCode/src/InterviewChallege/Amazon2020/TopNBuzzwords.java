package InterviewChallege.Amazon2020;

import java.util.*;

public class TopNBuzzwords {

    public  TopNBuzzwords(){ }
    public List<String> getTopToys(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2)->e1.getValue()-e2.getValue());

        for(String toy : toys) {
            map.put(toy,0);
        }
        for(String  quote : quotes){
            String[] strs = quote.toLowerCase().split("[, . !]+");
            for(String s : strs){
                s = s.trim();
                //System.out.println(s + " ");
                if(map.containsKey(s)){
                    map.put(s, map.get(s)+1);
                    System.out.println(s + " " + map.get(s));
                }
            }
        }
        for(String toy : map.keySet()){
          //  System.out.println(toy + " " + map.get(toy));
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
           // System.out.println(entry.getKey() + " " + entry.getValue());
            pq.add(entry);
            while(pq.size() > topToys){
               pq.poll();
            }
        }
        while(!pq.isEmpty()){
            result.add(pq.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }




    public static void main(String[] args) {
        TopNBuzzwords topWord = new TopNBuzzwords();
        List<String> result = new ArrayList<>();
        int numToys = 6;
        int topToys = 2;
        String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        int numQuotes = 6;
        String[]  quotes = {
                "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year, Elsa",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season"
        };
        result = topWord.getTopToys(numToys, topToys, toys, numQuotes,quotes);
        System.out.println(result);
    }

}
