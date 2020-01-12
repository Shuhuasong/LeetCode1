package Geometry;

public class MIniDistaneTypeWord_5310 {

    public int minimumDistance(String word){

        char[] words = word.toCharArray();
        int n = words.length;
        int distance = 0;
        for(int i=0; i<n; i++){
            int sx = (words[i] - 'A') / 6; //source x
            int sy = (words[i] - 'A') % 6; //source y

            int dx = (words[i+1]-'A') / 6;
            int dy = (words[i+1]-'A') % 6;

            distance += Math.abs(sx-dx) + Math.abs(sy-dy);
        }
        return distance;
    }

}
