package Array.Easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII_119 {
    public List<Integer> getRow(int rowIndex) {
        //List<List<Integer>> res = new ArrayList<>();

        List<Integer> curList = new ArrayList<>();
        curList.add(1);

        if(rowIndex == 0){
            return curList;
        }
        //res.add(curList);
        int count=0;
        while(count<rowIndex){
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
            //res.add(curList);
            count++;

        }
        return curList;
    }
}
