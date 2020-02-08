package Pramp;
//https://www.pramp.com/challenge/pK6A4GA5YES09qKmqG33
public class SalesPath {
    class Node{
        int cost;
        Node  parent;
        Node[] children;
    }
    int min_cost = Integer.MAX_VALUE;
    int getCheapestCost(Node rootNode){

        if(rootNode.children==null){
            return rootNode.cost;
        }

        for(Node child : rootNode.children){
            int cur_cost = rootNode.cost + getCheapestCost(child);
            if(cur_cost < min_cost){
                min_cost = cur_cost;
            }
        }
        return min_cost;
    }
}
