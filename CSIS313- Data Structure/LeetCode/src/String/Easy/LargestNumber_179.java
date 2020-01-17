package String.Easy;

/*
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class LargestNumber_179 {

    //run: 7ms (17%), 42.4MB
  /*  public String largestNumber(int[] nums) {
     StringBuilder sb = new StringBuilder();
     String[] num = new String[nums.length];
     for(int i=0; i<nums.length; i++){
         num[i] = Integer.toString(nums[i]);
     }
     Arrays.sort(num, (a, b) -> ((b+a).compareTo(a+b)));
     for(int i=0; i<nums.length; i++){
         sb.append(num[i]);
     }
     String res = sb.toString();
     if(res.charAt(0)=='0') return "0";
     return res;
    }

   */

// 8ms (76%) 9.4 MB
    public String largestNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>(){
            @Override
            public int compare(String n1, String n2){
                String n12 = n1 + n2;
                String n21 = n2 + n1;
                return n21.compareTo(n12);
            }
        });
        for(int n : nums){
            queue.offer(String.valueOf(n));
        }
        if(queue.peek().charAt(0)=='0') return "0";
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            sb.append(queue.poll());
        }
        return sb.toString();
    }


/*
  //run: 8 ms (77%), 9.4MB
    //C++
    string largestNumber(vector<int>& nums){
        vector<string> s;
        string res = "";
        for(int num : nums)
            s.push_back(to_string(num));
        sort(s.begin(), s.end(), [&](const string x, const string y){
                return x+y > y+x;
            });

            for(string st: s)
                res += st;
            if(res.size()>0 && res[0] =='0') return "0";
            return res;

    }

 */
};
