package String.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 turns to flip two consecutive “++” into “–”.
 Example:

Input: s = “++++“
Output:
[
”--++”,
"+--+",
"++--"
]
Note: If there is no valid move, return an empty list [].
 */

public class FlipGame_293 {

    // Time: O(n)
    // Space: O(1)
    public static List<String> generatePossibleNextMoves(String s){
        List<String> list = new ArrayList<>();
        for(int i=1; i<s.length(); i++){
            if(s.substring(i-1, i+1).equals("++")){
                list.add(s.substring(1, i-1) + "--" + s.substring(i+1));
            }
        }
        return list;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Entre one String: ");
        String s = scan.nextLine();
        System.out.println( generatePossibleNextMoves(s));
    }
}
