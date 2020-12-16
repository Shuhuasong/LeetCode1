package InterviewChallege.Amazon2020;

//LeetCode-1192

import java.util.*;
class Solution {
    public class Node {
        int val;
        boolean[] neighbours;
        public Node(int val, int size) {
            this.val = val;
            this.neighbours = new boolean[size];
        }
    }
    public class Graph {
        Node[] graph;
        public Graph(int n) {
            this.graph = new Node[n];
        }
    }
    public Graph makeGraph(int n) {
        Graph g = new Graph(n);
        for (int i = 0; i < n; i++) {
            g.graph[i] = new Node(i, n);
        }
        return g;
    }
    public Graph fillNeighbours(int n, Graph g, List<List<Integer>> connections) {
        int start = 0;
        int end = 1;
        for (int i = 0; i < connections.size(); i++) {
            int x = connections.get(i).get(start);
            int y = connections.get(i).get(end);
            g.graph[x].neighbours[y]= true;
            g.graph[y].neighbours[x]= true;
        }
        return g;
    }
    public void dfs(Graph g, int currentNode, int n, boolean[] visited) {
        Node node = g.graph[currentNode];
        visited[currentNode] = true;
        for (int i = 0; i < n; i++) {
            if (node.neighbours[i] == true && visited[i] == false) {
                dfs(g, i, n, visited);
            }
        }
    }
    public boolean allVisited(boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }
    public void fillResult(int u, int v, List<List<Integer>> res) {
        // to make u < v
        if (u > v) {
            int temp = u;
            u = v;
            v = temp;
        }
        int start = 0;
        int end = 1;
        for (int entry = 0; entry < res.size(); entry++) {
            if (res.get(entry).get(start) == u && res.get(entry).get(end) == v) {
                return;
            }
        }
        ArrayList<Integer> newResult = new ArrayList<Integer>();
        newResult.add(u);
        newResult.add(v);
        res.add(newResult);
    }
    public void skeletalDfs(int n, Graph g, List<List<Integer>> res) {
        for (int node = 0; node < n; node++) {
            Node current = g.graph[node];
            for (int i = 0; i < n; i++) {
                if (current.neighbours[i] == true && i != node) {
                    current.neighbours[i] = false;
                    g.graph[i].neighbours[node] = false;
                    //call dfs
                    boolean[] visited = new boolean[n];
                    dfs(g, node, n, visited);
                    if (!allVisited(visited, n)) {
                        // fill res
                        fillResult(node, i, res);
                    }
                    current.neighbours[i] = true;
                    g.graph[i].neighbours[node] = true;
                }
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Graph g = makeGraph(n);
        g = fillNeighbours(n, g, connections);
        List<List<Integer>> result = new ArrayList<>();
        skeletalDfs(n, g, result);
        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> arg = new ArrayList<List<Integer>>();
        List<Integer> list = Arrays.asList(0,1);
        arg.add(list);
        list = Arrays.asList(0,2);
        arg.add(list);
        list = Arrays.asList(1,2);
        arg.add(list);
        list = Arrays.asList(2,3);
        arg.add(list);
        list = Arrays.asList(2,5);
        arg.add(list);
        list = Arrays.asList(3,4);
        arg.add(list);
        list = Arrays.asList(5,6);
        arg.add(list);
        list = Arrays.asList(5,8);
        arg.add(list);
        list = Arrays.asList(6,7);
        arg.add(list);
        list = Arrays.asList(7,8);
        arg.add(list);
        s.criticalConnections(9, arg);
    }
}



/*
public class CriticalConnections {

    class PairInt{
        int first;
        int second;
        public PairInt(int f, int s){
            this.first = f;
            this.second = s;
        }
    }

    List<PairInt> list;
    Map<Integer, Boolean> visited;
    List<PairInt> criticalConnections(int numOfServers, int numOfConnections,
                                      List<PairInt> connections)
    {
        Map<Integer, HashSet<Integer>> adj = new HashMap<>();
        for(PairInt connection : connections){
            int u = connection.first;
            int v = connection.second;
            if(adj.get(u) == null){
                adj.put(u,new HashSet<Integer>());
            }
            adj.get(u).add(v);
            if(adj.get(v) == null){
                adj.put(v,new HashSet<Integer>());
            }
            adj.get(v).add(u);
        }

        list = new ArrayList<>();
        for(int i =0;i<numOfConnections;i++){
            visited = new HashMap<>();
            PairInt p = connections.get(i);
            int x = p.first;
            int y = p.second;
            adj.get(x).remove(y);
            adj.get(y).remove(x);
            DFS(adj,1);
            if(visited.size()!=numOfServers){
                if(p.first > p.second)
                    list.add(new PairInt(p.second,p.first));
                else
                    list.add(p);
            }
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        return list;
    }

    public void DFS(Map<Integer, HashSet<Integer>> adj, int u){
        visited.put(u, true);
        if(adj.get(u).size()!=0){
            for(int v : adj.get(u)){
                if(visited.getOrDefault(v, false)== false){
                    DFS(adj,v);
                }
            }
        }
    }
}

 */
