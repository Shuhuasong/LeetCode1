package String.Medium;

public class Encoding_Decoding {
    public  static String encode(String str){
        StringBuilder sb = new StringBuilder();
        char temp = str.charAt(0);
        int count = 1;
        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            if(curr==temp){
                count++;
            }else{
                sb.append(temp).append(count);
                count = 1;
            }
             temp = curr;
        }
        sb.append(temp).append(count);
        return sb.toString();
    }

    public static String decode(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i += 2){
            int count = Integer.valueOf(""+str.charAt(i+1)); //getting the character and it’s count
            for(int j=0; j<count; j++){
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(encode("aaabcddyyyyrrttpkmmmm")); //output: a3b1c1d2y4r2t2p1k1m4
        System.out.println(decode("a3b1c1d2y4r2t2p1k1m4")); //output: aaabcddyyyyrrttpkmmmm
    }

}



