package LLReverse;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.*;

public class LLReverse {
    class listNode {
        String data;
        listNode next;
        listNode(){
            data = "dummy";
            next = null;
        }
        listNode(String data, listNode next){
            this.data = data;
            this.next = next; ;
        }

        void printNode(listNode node, File outFile) throws IOException {
        try{
            if(!outFile.exists()){
                outFile.createNewFile();
            }
            FileWriter fw = new FileWriter(outFile);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(node.data);
            bw.write(node.hashCode());
            bw.write(node.next.hashCode());
            bw.write(node.next.data);
        }catch(Exception e){
            e.printStackTrace();
        }
       }
    }

    class LinkedList {
       listNode listHead;

       //Constructor
       LinkedList(){
           listNode dummy = new listNode();
           listHead = dummy;
       }
       //Construct a LinkedList

       void listInsert(listNode newNode) {
           listNode spot = findSpot(newNode);
           newNode.next = spot.next;
           spot.next = newNode;
       }

       listNode findSpot(listNode newNode) {
           listNode curNode = listHead;
           while(curNode.next != null){
               if(curNode.next.data.compareTo(newNode.data) > 1) break;
               curNode = curNode.next;
           }
           return curNode;
       }
    }

    public static void main(String args[]) throws FileNotFoundException {
        Scanner inFile = new Scanner(new FileReader(args[1]));
        Scanner outFile1 = new Scanner(new FileReader(args[2]));
        Scanner outFile2 = new Scanner(new FileReader(args[3]));


        inFile.close();
        outFile1.close();
        outFile2.close();

        /*
         inFile.next()
        read string from the input file:
        String str;
        str = inFile.nextline();
         */
    }
}
