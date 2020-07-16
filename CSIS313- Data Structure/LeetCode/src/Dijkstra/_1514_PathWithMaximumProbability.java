package Dijkstra;

import java.util.*;

public class _1514_PathWithMaximumProbability {
    //Solution #1: Queue + List
    //Time: O(n^2)  space: (n+e)
    List<Integer>[] graph;
    Map<String, Double> map;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        graph = new ArrayList[n];
        map = new HashMap<>();
        for(int i=0; i<n; i++) { graph[i] = new ArrayList<>(); }
        for(int i=0; i<edges.length; i++){
            int[] edge = edges[i];
            int v1 = edge[0];
            int v2 = edge[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
            map.put(v1 + "," + v2, succProb[i]);
            map.put(v2 + "," + v1, succProb[i]);
        }

        double[] cost = new double[n];
        cost[start] = 1.0;
        Queue<double[]> q = new LinkedList<>();
        q.offer(new double[]{start, 1.0});
        while(!q.isEmpty()){
            double[] pair = q.poll();
            int parent = (int)pair[0];
            double pro = pair[1];
            List<Integer> child = graph[parent];
            for(int c : child){
                double cProb = map.get(parent+","+c);
                double newPro = pro * cProb;
                if(newPro > cost[c]){
                    cost[c] = newPro;
                    q.offer(new double[]{c, newPro});
                }
            }
        }
        return cost[end];
    }



}
