package String.Easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz_412 {

    // run time: 1 ms  (98%) 45.9
    //Time: O(n)  Space: O(n)
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        int i = 1;
        while(i<=n){
            if(i%3 == 0 && i%5==0) list.add("FizzBuzz");
            else if(i%5 == 0) list.add("Buzz");
            else if(i%3 == 0) list.add("Fizz");
            else
                list.add(Integer.toString(i));
            i++;
        }
        return list;
    }

}
