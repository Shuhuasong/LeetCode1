package Dijkstra;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _787_CheapestFlightsWithinKstops {

    //Solution #1:  using heap and map
    // Time: O(nlogn)  Space: O(n+e)

    Map<Integer, Map<Integer, Integer>> graph;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        graph = new HashMap<>();
        for(int[] f : flights){
            if(!graph.containsKey(f[0])){
                graph.put(f[0], new HashMap<Integer, Integer>());
            }
            graph.get(f[0]).put(f[1], f[2]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
        pq.offer(new int[]{0, src, 0});
        while(!pq.isEmpty()){
            int[] pair = pq.poll();
            int cost = pair[0];
            int city = pair[1];
            int stops = pair[2];
            if(city==dst) return cost;
            if(stops<=K){
                Map<Integer, Integer> child = graph.getOrDefault(city, new HashMap<Integer, Integer>());
                for(int c : child.keySet()){
                    pq.offer(new int[]{cost+child.get(c), c, stops+1});
                }

            }
        }
        return -1;
    }

    //Solution #2:  using heap + 2D array
    // Time: O(nlogn)  Space: O(n+e)
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        for(int[] f : flights){ //f[0] : src   f[1]: dst   f[2]: cost
            graph[f[0]][f[1]] = f[2];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
        pq.offer(new int[]{0, src, K+1});
        while(!pq.isEmpty()){
            int[] pair = pq.poll();
            int cost = pair[0], city = pair[1], remainStop = pair[2];
            if(city==dst) return cost;
            if(remainStop>0){
                for(int i=0; i<n; i++){
                    if(graph[city][i]>0){
                        pq.offer(new int[]{cost+graph[city][i], i, remainStop-1});
                    }
                }
            }
        }
        return -1;
    }
}
