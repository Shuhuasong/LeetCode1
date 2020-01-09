package Divide_and_Conquer;

import java.util.Vector;

public class NumShipInRectangle {

    class Sea {
       bool hasShips(Vector<Integer> topRight, Vector<Integer> bottomLeft);
  };

    int countShips(Sea sea, Vector<Integer> topRight, Vector<Integer> bottomLeft){
        int x1 = bottomLeft.elementAt(0), y1 = bottomLeft.elementAt(1);
        int x2 = topRight.elementAt(0), y2 = topRight.elementAt(1);
        if(x1 > x2 || y1 > y2 || !sea.hasShips(topRight, bottomLeft) return 0;
        if(x1 == x2 && y1 == y2) return 1;
        int x3 = (x1 + x2)/2;
        int y3 = (y1 + y2)/2;
        return countShips(sea, {x1, y1}, {x3, y3} ) +
               countShips(sea, {x3, y2}, {x1, y3+1} ) +
               countShips(sea, {x2, y3}, {x3+1, y3} ) +
               countShips(sea, {x2, y2}, {x3+1, y3+1} ) ;
    }

}
