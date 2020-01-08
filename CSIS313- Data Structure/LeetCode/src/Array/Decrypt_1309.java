package Array;

public class Decrypt_1309 {
// run time: 1ms, memory: 35.4 MB
  /*  public String freAlphabets(String s){
        if(s.length()==0) return "";
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index<s.length()){
            if(index+2 < s.length() && s.charAt(index+2)=='#'){
                char ch = 'j';
                ch += (Integer.parseInt(s.substring(index, index+2))-10);
                sb.append(String.valueOf(ch));
                index += 3;
            }else{
                char ch = 'a';
                ch += (Integer.parseInt(s.substring(index, index+2))-1);
                sb.append(String.valueOf(ch));
                index++;
            }
        }
        return sb.toString();
    }

   */

    // run time: 0ms, memory: 34.5 MB
    public String freqAlphabets(String s) {
        char[] alpha ={ 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z' };
        StringBuilder sb = new StringBuilder();

        for(int i=s.length()-1; i>=0; i++){
            char c = s.charAt(i);
            if(c!='#'){
                int index = ((int)c) - '1'; // char
                sb.append(alpha[index]);
            }else{
                char c1 = s.charAt(i-1);
                char c2 = s.charAt(i-2);
                int i1 = ((int)c1) - '0';
                int i2 = ((int)c2) - '0';
                int index = (i2 * 10) + i1;
                sb.append(alpha[index]);
                i = i - 2; //move i forward
            }
        }
        return sb.reverse().toString();
    }

}




