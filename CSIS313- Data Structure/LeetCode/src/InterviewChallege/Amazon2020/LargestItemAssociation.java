package InterviewChallege.Amazon2020;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class LargestItemAssociation{

    class PairString{
        String first, second;
        PairString(String first, String second){
            this.first = first;
            this.second = second;
        }
        @Override
        public String toString() {
            return first + " ," + second;
        }
    }
    public LargestItemAssociation(){}

    // Time complexity O(n2) and space is O(n)
    public static List<String> largestItemAssociation(List<PairString> pairs) {
        if (pairs.isEmpty())
            return null;
        PriorityQueue<Set<String>> max_heap = new PriorityQueue<>(//
                (l1, l2) -> Integer.compare(l2.size(), l1.size()));//
        Collections.sort(pairs, (a, b) -> a.first.compareTo(b.first));
        for (int pair = 0; pair < pairs.size(); pair++) {
            Set<String> buildList = new TreeSet<>(Arrays.asList(pairs.get(pair).first, pairs.get(pair).second));
            for (int inner = pair + 1; inner < pairs.size(); inner++) {
                mergeTag(buildList, pairs.get(inner));
            }
            max_heap.add(buildList);
        }

        return max_heap.poll().stream().collect(Collectors.toList());
    }

    private static void mergeTag(Set<String> buildList, PairString pairString) {
        if (buildList.contains(pairString.first) && buildList.contains(pairString.second))
            return;
        if (buildList.contains(pairString.first)) {
            buildList.add(pairString.second);
        } else if (buildList.contains(pairString.second)) {
            buildList.add(pairString.first);
        }

    }

   /* public List<String> largestItemAssociation(List<PairString> itemAssociation) {
        // write your code here
        List<List<String>> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        int maxSize = 0;
        for(PairString pair : itemAssociation){
            String first = pair.first;
            String second = pair.second;
            map.put(first, second);
        }
        for(String k : map.keySet()){
            List<String> cur = new ArrayList<>();
            String key = k;
            String value = map.get(k);
            cur.add(key);
            cur.add(value);
            while(map.containsKey(value)){
                 key = value;
                 value = map.get(key);
                cur.add(key);
                cur.add(value);
            }
            maxSize = Math.max(maxSize, cur.size());
            list.add(cur);
        }
        for(List<String> curList : list){
            if(curList.size()==maxSize){
                result = curList;
            }
        }
        return result;
    }
    */
    public static void main(String args[]) throws IOException{
        LargestItemAssociation itemAsso = new LargestItemAssociation();
    }
}
