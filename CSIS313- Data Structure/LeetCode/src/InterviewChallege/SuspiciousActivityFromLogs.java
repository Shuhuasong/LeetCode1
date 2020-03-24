package InterviewChallege;

/*
Question:
first number: sender
second number: receiver
third number: amount
logs = { "88 99 200", "88 99 300", "99 32 100", "12 12 200" }
function return an array of string denoting user_id's of suspicious user_id's
of suspious users who have involved in at least threshold number of log entries. The
id's should be ordered ascending by numeric value.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuspiciousActivityFromLogs {
    public static List<String> processLogs(List<String> logs, int threshold) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        for (String log : logs) {
            String[] arr = log.split(" ");
            if(arr[0].equals(arr[1])){
                count.put(arr[0], count.getOrDefault(arr[0], 0)+1);
            }else{
                count.put(arr[0], count.getOrDefault(arr[0], 0)+1);
                count.put(arr[1], count.getOrDefault(arr[2], 0)+1);
            }
        }
        for(String s : count.keySet()){
            int c = count.get(s);
            if(c>=threshold){
                res.add(s);
            }
        }
        res.sort((s1, s2)->Integer.valueOf(s1)-Integer.valueOf(s2));
        return res;

      
    }
}
