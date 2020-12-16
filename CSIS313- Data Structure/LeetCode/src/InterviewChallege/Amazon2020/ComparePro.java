package InterviewChallege.Amazon2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ComparePro {

    public ComparePro(){}

    public static boolean compareProduct(int num){
        if(num < 10) return false;
        int oddProdValue = 1, evenProdValue = 1;
        while(num > 0){
            int digit = num % 10;
            oddProdValue *=digit;
            num = num / 10;
            if(num==0) break;
            digit = num % 10;
            evenProdValue *= digit;
            num = num / 10;
        }
        return evenProdValue == oddProdValue;
    }

    public int calculateSumOfNumbersInString(String inputString){
        String temp = "";
        int sum = 0;
        for(int i=0; i<inputString.length(); i++){
            char ch = inputString.charAt(i);
            if(Character.isDigit(ch)){
                temp += ch;
            }
            else{
                int cur = Integer.parseInt(temp);
                sum = sum + cur;
                temp = "0";
            }

        }
        return sum + Integer.parseInt(temp);
    }


    public static void main(String args[]) throws IOException {
        //The Scanner class is used to read file in tokens from an input stream
        ComparePro comp = new ComparePro();
        InputStream in;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter input data, list ");
        String line = "a2b3c10d";

        int result = comp.calculateSumOfNumbersInString(line);
        System.out.println(result);
    }
}
