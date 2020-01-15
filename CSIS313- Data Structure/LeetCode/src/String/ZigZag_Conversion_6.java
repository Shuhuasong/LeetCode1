package String;

//runtime: 4ms (80.84%)
//Time Complexity: O(n);
//Space Complexity: O(n);
public class ZigZag_Conversion_6 {
    public String convert(String s, int numRows) {
        if(numRows<2) return s;
        char[] c = s.toCharArray();
        int len = s.length();
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++){
            sbs[i] = new StringBuilder();
        }

        int i=0;
        while(i<len){
            for(int j=0; j<numRows && i<len ; j++){
                sbs[j].append(c[i++]);
            }
            for(int j=numRows-2; j>=1 && i<len; j--){
                sbs[j].append(c[i++]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int m=0; m<numRows; m++){
            sb.append(sbs[m]);
        }
        return sb.toString();
    }
}


/*
 public String convert(String s, int numRows) {
       if(numRows<=1) return s;

       StringBuilder[] sbs = new StringBuilder[numRows];
       for(int i=0; i<numRows; i++){
           sbs[i] = new StringBuilder("");
       }

       for(int i=0; i<s.length(); i++){
           int index = i % (2*numRows-2);
           index = index < numRows ? index : 2*numRows-2 - index;
           sbs[index].append(s.charAt(i));
       }
       for(int i=1; i<sbs.length; i++){
           sbs[0].append(sbs[i]);
       }
       return sbs[0].toString();
   }
 */