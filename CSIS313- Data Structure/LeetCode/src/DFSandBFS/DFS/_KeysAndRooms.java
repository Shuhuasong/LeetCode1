package DFSandBFS.DFS;

import java.util.List;
import java.util.Stack;

public class _KeysAndRooms {
    //Time: O(N+E) N: the number of rooms, E: the total number of keys
    //Space: O(N)
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] seem = new boolean[n];
        seem[0] = true;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        while(!st.isEmpty()){
            int curKey = st.pop();
            for(int key : rooms.get(curKey)){
                if(seem[key]==false){
                    seem[key] = true;
                    st.push(key);
                }
            }
        }
        for(int i=0; i<n; i++){
            if(seem[i]==false) return false;
        }
        return true;
    }
}

/*
idea:  When visiting a room for the first time, look at all the keys
 in that room. For any key that hasn't been used yet, add it to the
  todo list (stack) for it to be used.
 */