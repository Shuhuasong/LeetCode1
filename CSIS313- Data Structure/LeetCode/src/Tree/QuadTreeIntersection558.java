package Tree;

public class QuadTreeIntersection558 {

    // Definition for a QuadTree node.
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };


    public Node intersect(Node quadTree1, Node quadTree2) {
      Node newNode = new Node();
      if(quadTree1==null && quadTree2==null) return null;
      else if(quadTree1.isLeaf && quadTree2.isLeaf) {
          newNode.isLeaf = true;
          newNode.val = quadTree1.val || quadTree2.val;
      }
      else if(quadTree1.isLeaf){
          newNode = quadTree1.val ? quadTree1 : quadTree2;
        }
      else if(quadTree2.isLeaf){
          newNode = quadTree2.val ? quadTree2 : quadTree1;
      }
      else{
          newNode.isLeaf = false;
          newNode.topLeft =  intersect(quadTree1.topLeft,quadTree2.topLeft);
          newNode.topRight = intersect(quadTree1.topRight,quadTree2.topRight);
          newNode.bottomLeft = intersect(quadTree1.bottomLeft,quadTree2.bottomLeft);
          newNode.bottomRight =  intersect(quadTree1.bottomRight,quadTree2.bottomRight);

      }
      if(!newNode.isLeaf && newNode.topLeft.isLeaf && newNode.topRight.isLeaf &&
          newNode.bottomLeft.isLeaf && newNode.bottomRight.isLeaf &&
          newNode.topLeft.val == newNode.topRight.val && newNode.topRight.val==newNode.bottomLeft.val
          && newNode.bottomLeft.val==newNode.bottomRight.val){
          newNode.isLeaf = true;
          newNode.val = newNode.topLeft.val;
      }

      return newNode;
    }
}
