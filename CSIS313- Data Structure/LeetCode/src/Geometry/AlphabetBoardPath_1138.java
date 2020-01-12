package Geometry;

public class AlphabetBoardPath_1138 {

    //Time Complexity: O(n)
    /*
    public String alphabetBoardPath(String target)  {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();

        int[] oriPos = new int[]{0,0};
        for(char c : target.toCharArray()){
            int pos = alpha.indexOf(c);
            int row = pos/5;
            int col = pos % 5;

            if(row < oriPos[0]){
                addSB('U', oriPos[0]-row, sb);
            }
            if(col < oriPos[1]){
                addSB('L', oriPos[1]-col, sb);
            }
            if(row > oriPos[0]){
                addSB('D', row-oriPos[0], sb);
            }
            if(col > oriPos[1]){
                addSB('R', col-oriPos[1], sb);
            }

            sb.append('!');
            oriPos[0] = row;
            oriPos[1] = col;
        }
        return sb.toString();
    }

    private void addSB(char c, int n, StringBuilder sb) {
        for(int i=0; i<n; i++){
            sb.append(c);
        }
    }

     */

    public String alphabetBoardPath(String target){
        StringBuilder sb = new StringBuilder();
        int x = 0, y = 0; //source x, y
        for(char c : target.toCharArray()){
            int dx = (c-'a') / 5;
            int dy = (c-'a') % 5;
            if(dx < x){
                for(int i=0; i<x-dx; i++) sb.append('U');
            }
            if(dy < y){
                for(int i=0; i<y-dy; i++) sb.append('L');
            }
            if(dx > x){
                for(int i=0; i<dx-x; i++) sb.append('D');
            }
            if(dy > y){
                for(int i=0; i<dy-y; i++) sb.append('R');
            }
            sb.append('!');
            x = dx;
            y = dy;
        }
        return sb.toString();
    }
}
