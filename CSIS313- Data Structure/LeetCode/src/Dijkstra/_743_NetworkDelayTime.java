package Dijkstra;

import java.util.*;

public class _743_NetworkDelayTime {
    //Solution #1:  using heap
    // Time: O(nlogn)  Space: O(n+e)
    List<Integer>[] graph;
    Map<String, Integer> map;
    public int networkDelayTime(int[][] times, int N, int K) {
        graph = new ArrayList[N+1];
        map = new HashMap<>();
        boolean[][] visited = new boolean[N+1][N+1];
        for(int i=0; i<=N; i++){ graph[i] = new ArrayList<>(); }
        for(int[] time : times){
            int v1 = time[0];
            int v2 = time[1];
            int traTime = time[2];
            graph[v1].add(v2);
            map.put(v1+","+v2, traTime);
        }

        int[] spend = new int[N+1];
        Arrays.fill(spend, Integer.MAX_VALUE);

        spend[K] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{ return a[1]-b[1]; });
        pq.add(new int[]{K, 0});
        while(!pq.isEmpty()){
            int[] pair = pq.poll();
            int parent = pair[0];
            int ti = pair[1];
            List<Integer> child = graph[parent];

            for(int c : child){
                if(visited[parent][c]) continue;
                visited[parent][c] = true;
                int cTime = map.get(parent+","+c);
                int newTime = ti + cTime;
                spend[c] = Math.min(spend[c], newTime);
                pq.offer(new int[]{c, newTime});

            }
        }
        int res = 0;
        for(int i=1; i<spend.length; i++){
            if(spend[i]==Integer.MAX_VALUE) return -1;
            else
                res = Math.max(spend[i], res);
        }
        return res;
    }


    //Solution #2:  using queue
    // Time: O(n^2)  Space: O(n+e)

/*    List<Integer>[] graph;
    Map<String, Integer> map;
    public int networkDelayTime(int[][] times, int N, int K) {
        graph = new ArrayList[N+1];
        map = new HashMap<>();

        for(int i=0; i<=N; i++){ graph[i] = new ArrayList<>(); }
        for(int[] time : times){
            int v1 = time[0];
            int v2 = time[1];
            int traTime = time[2];
            graph[v1].add(v2);
            map.put(v1+","+v2, traTime);
        }

        int[] spend = new int[N+1];
        Arrays.fill(spend, Integer.MAX_VALUE);

        spend[K] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{K, 0});
        while(!q.isEmpty()){
            int[] pair = q.poll();
            int parent = pair[0];
            int ti = pair[1];
            List<Integer> child = graph[parent];

            for(int c : child){
                int cTime = map.get(parent+","+c);
                int newTime = ti + cTime;
                if(newTime < spend[c]){
                    spend[c] = Math.min(spend[c], newTime);
                    q.offer(new int[]{c, newTime});
                }
            }
        }
        int res = 0;

        for(int i=1; i<spend.length; i++){
            if(spend[i]==Integer.MAX_VALUE) return -1;
            else
                res = Math.max(spend[i], res);
        }
        return res;
    }

 */
}
