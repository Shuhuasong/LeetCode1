package LLReverse;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.*;

public class LinkedList {

    private static listNode listHead;
    private static listNode tail;
    static class listNode {
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

        void printNode(listNode node, BufferedWriter fw) throws IOException {
            fw.write("(" + node.data + " ," + node + " ," + node.next + " ," + node.next.data + ")");
        }
    }





    //Constructor
    LinkedList(){
        listNode dummy = new listNode();
        listHead = dummy;
        tail = new listNode();
    }
    //Construct a LinkedList
    public	void constructLL(Scanner reader, BufferedWriter writer) throws IOException {
        while(reader.hasNext()){ //while there is another token to read
            String str = reader.next();//reads in the String tokens and skip white-space character to start reading next token
            listNode newNode = new listNode(str, null);//can't use nextLine(), because the '\n' character is part of a valid line token. it will return empty string
            listInsert(newNode);
            printList(listHead,writer); ////
            System.out.println(str);
        }
    }

    public void listInsert(listNode newNode) {
        if(listHead.next == null) {
            listHead.next = newNode;
        }else{
            listNode spot = findSpot(newNode);
            newNode.next = spot.next;
            spot.next = newNode;
        }
    }

    public listNode findSpot(listNode newNode) {
        listNode curNode = listHead;
        while(curNode!= null && curNode.next != null){
            if(curNode.next.data.compareTo(newNode.data) > 0) break;
            curNode = curNode.next;
        }
        return curNode;
    }

    public	listNode findMiddleNode(BufferedWriter fw) throws IOException {
        listNode  walk1 = listHead;
        listNode walk2 = listHead;
        listNode node = new listNode();
        while(walk2 != null && walk2.next != null){
            node.printNode(walk1, fw);
            walk1 = walk1.next;
            walk2 = walk2.next.next;
        }
        return walk1;
    }

    public void reverseLL(BufferedWriter fw) throws IOException {
        listNode last = listHead;
        listNode spot = listHead;
        while(last.next != null){
            spot = last.next;
            moveSpotNodeToFront(spot);
            printList(tail, fw);
        }
    }
    public void moveSpotNodeToFront(listNode spot){
        listHead.next = spot.next;
        spot.next = tail.next;
        tail.next = spot;
    }



    public void printList(listNode listHead, BufferedWriter fw) throws IOException {
        listNode cur = listHead;
        fw.write("listHead");
        while(cur != null && cur.next != null){

            fw.write("->(" + cur.data + " ," + cur + " ," + cur.next + " ," + cur.next.data + ")\n");
            cur = cur.next;
        }
        fw.write("->(" + cur.data + " ," + cur +  ")->");
        fw.write("NULL" + "\n");
    }


    public static void main(String args[]) throws IOException {
        //The Scanner class is used to read file in tokens from an input stream
        LinkedList list = new LinkedList();
        Scanner reader = new Scanner(new FileReader(args[0]));
        BufferedWriter writer1 = new BufferedWriter(new  FileWriter(new File(args[1]))) ;
        BufferedWriter writer2 = new BufferedWriter(new  FileWriter(new File(args[2]))) ;

        //print the completed linkedlist
        list.constructLL(reader, writer2); /////
        writer1.write("Completed LinkedList: ");
        list.printList(listHead, writer1);

        writer1.write("Reverse LinkedList: ");

        list.reverseLL(writer2);
        list.printList(tail,writer1);

        reader.close();
        writer1.close();
        writer2.close();

        /*
        Scanner inFile = new Scanner(new FileReader(args[1]));
         inFile.next()
        read string from the input file:
        String str;
        str = inFile.nextline();
         */
    }
}
