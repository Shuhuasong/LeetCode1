package Graph;

public class CheckIfItIsAStraightLine_1232 {
    //Time: O(n) Space: O(1)
    //run: 0ms 100%
    public boolean checkStraightLine(int[][] coordinates) {
        for(int i=2; i < coordinates.length; i++){
            if((coordinates[1][1]-coordinates[0][1]) * (coordinates[2][0]-coordinates[0][0]) !=
                    (coordinates[2][1]-coordinates[0][1]) * (coordinates[1][0]-coordinates[0][0]) ){
                return false;
            }
        }
        return true;
    }
}
