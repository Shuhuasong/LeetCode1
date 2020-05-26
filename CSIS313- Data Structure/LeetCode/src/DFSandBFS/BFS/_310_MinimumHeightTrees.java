package DFSandBFS.BFS;

import java.util.*;

public class _310_MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n==1){
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        Map<Integer, List<Integer>> map= new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] pair: edges){
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
            degree[pair[0]]++;
            degree[pair[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(degree[i]==1){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            List<Integer> curList = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                int cur = queue.poll();
                curList.add(cur);
                for(int vertex: map.get(cur)){
                    degree[vertex]--;
                    if(degree[vertex]==1) queue.add(vertex);
                }
            }
            res = curList;
        }

        return res;
    }
}

//   Map(Graph)
// 0    3->
// 3    0->1->2->4
// 1    3->
// 2    3->
// 4    3->5
// 5    4->

//      degree
//    0    1    2   3   4   5
//    1    1    1   4   2   1
// queue: 0    1    2   5