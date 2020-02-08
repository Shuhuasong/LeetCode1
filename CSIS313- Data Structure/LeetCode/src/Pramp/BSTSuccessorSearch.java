package Pramp;

/*public class BSTSuccessorSearch {
    class Node {
        int key;
        Node left;
        Node right;
        Node parent;

        Node(int key){
            this.key = key;
            left = null;
            right = null;
            parent = null;
        }
    }

    class BinarySearchTree {
        Node root;
        Node findInOrderSuccessor(Node inputNode){

        }

        void insert(int key){
            if(this.root==null){
                this.root = new Node(key);
                return;
            }

            Node currentNode = this.root;
            Node newNode = new Node(key);

            while(currentNode != null){
                if(key < currentNode.key){
                    if(currentNode.left == null){
                        currentNode.left = newNode;
                        newNode.parent = currentNode;
                        break;
                    }else{
                        currentNode = currentNode.left;
                    }
                }else {
                    if(currentNode.right == null){
                        currentNode.right = newNode;
                        newNode.parent = currentNode;
                        break;
                    }else{
                        currentNode = currentNode.right;
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Node test = null, succ = null;

        //Create a Binary Search Tree
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(20);
        tree.insert(9);
        tree.insert(25);
        tree.insert(5);
        tree.insert(12);
        tree.insert(11);
        tree.insert(14);
        //Get a reference to the node whose key is 9
        test = tree.getNodeByKey(9);
    }
}

 */
