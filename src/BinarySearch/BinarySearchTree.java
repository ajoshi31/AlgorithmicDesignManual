package BinarySearch;

public class BinarySearchTree {

    /* Class containing left and right child of current node and key value*/

    private class Node {
        int key;
        Node left, right;

        private Node(int item) {
            this.key = item;
            this.left = this.right = null;
        }
    }

    private Node root; //initialize a variable root of type Node which is head of the BST

    // Constructor
    private BinarySearchTree() {
        //initialize root to null
        root = null;
    }

    // This method mainly calls insertRec()
    private void insert(int key) {
        root = insertRec(root, key);  // every insertion should check from root so root is passed
    }

    /* A recursive function to insert a new key in BST */

    private Node insertRec(Node root, int key) {

        /*If tree is empty, return the insert key as root or new node */
        if (root == null) {
            // because root was null we need to initialize root as our defined new Node
            //It will create our first node with key and left and right as null
            root = new Node(key);
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    private void inorder() {
        inorderRec(root);
    }

    private void processKeyNode(int key) {
        System.out.println(key);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            processKeyNode(root.key);
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.inorder();
    }
}