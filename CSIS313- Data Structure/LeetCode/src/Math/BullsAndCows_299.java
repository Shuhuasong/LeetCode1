package Math;

import java.util.ArrayList;
import java.util.List;

public class BullsAndCows_299 {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        List l1 = new ArrayList<>();
        List l2 = new ArrayList<>();
        char[] ch1 = secret.toCharArray();
        char[] ch2 = guess.toCharArray();

        for(int i=0; i<ch1.length; i++){
            if(ch1[i]==ch2[i]){
                bull++;
            }
            else{
                l1.add(ch1[i]);
                l2.add(ch2[i]);
            }
        }

        for(int j=0; j<l1.size(); j++){
            if(l2.contains(l1.get(j))) {
                cow++;

                //delete this item if there is a duplicate
                l2.remove(l1.get(j));
            }
        }
        String res = Integer.toString(bull) + "A" + Integer.toString(cow) +"B";
        return res;
    }
}
