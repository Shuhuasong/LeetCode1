package String.Easy;


/*
case : "edwardshi", "edward", "edwar"
res =
   edwardshi
   edwardsh
   edwards                            edward         edward
   edward --> in this case we find it strs[1].indexOf(res) = 0, then i = 2
   edwar  --> in this case we find it strs[2].indexOf(res) = 0
                                      edwar          edwar

 */

//run time: 0 ms (100%)
//time: O(n)
//space: O(1)
public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length == 0) return "";
        String res = strs[0];
        for(int i=1; i<strs.length; i++){
            while(strs[i].indexOf(res) != 0){  //find the first occurence of res in strs[i]
                 // edwar.indexOf("edward"), it means we didn't find the "edward" in "edwar", if it == 0, it means it find the string
                    res = res.substring(0, res.length()-1); //if we didn't find it, we remove the last character
            }
        }
        return res;
    }
}
