package Array.Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows <= 0) return res;

        List<Integer> curList = new ArrayList<>();


        curList.add(1);
        res.add(curList);
        while(res.size() < numRows){
            List<Integer> tempList = new ArrayList<>();
            int n = curList.size();
            tempList.add(1);

            if(n>1){
                for(int i=0; i<=n-2; i++){
                    tempList.add(curList.get(i)+curList.get(i+1));
                }
            }

            tempList.add(1);
            curList = tempList;
            res.add(curList);
        }
        return res;
    }
}
