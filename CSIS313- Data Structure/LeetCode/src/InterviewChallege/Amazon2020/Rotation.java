package InterviewChallege.Amazon2020;

import LLReverse.LinkedList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rotation {

   public Rotation(){}

    public static int countRotations(int size, int list[]){
        int res = countRotationsUtil(list, 0, size-1);
        for(int d : list){
            System.out.print(d + " ");
        }
        System.out.println( "res:" + res);

        return res;
    }

    public static int countRotationsUtil(int list[], int low, int high){
        if(high < low) return 0;
        if(high == low) return low;
        int mid = low + (high - low)/2;
        if(mid < high && list[mid+1] < list[mid]){
            return (mid+1);
        }
        if(mid > low && list[mid] < list[mid-1]){
            return mid;
        }
        if(list[high] > list[mid])
            return countRotationsUtil(list, low, mid);

        return countRotationsUtil(list, mid, high);
    }


    public static void main(String args[]) throws IOException {
        //The Scanner class is used to read file in tokens from an input stream
        Rotation rotation = new Rotation();
        //Scanner reader = new Scanner(new FileReader(args[0]));
        InputStream in;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter input data, list ");
        String line = null;
//        String[] input = new String[3];
//        int i=0;
//        while((line=br.readLine())!=null){
//           input[i++] = line;
//        }
        line=br.readLine();
        String[] strs = line.trim().split("\\s+");
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<strs.length; i++){
            list.add(Integer.parseInt(strs[i]));
        }
        int size = list.size();
        int[] data = new int[size];
        int i = 0;
        for(int d : list) data[i++] = d;
        rotation.countRotations(size, data);


    }
}


