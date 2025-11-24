import java.util.*;

public class AVLTree {
    static class Node {
        int data;
        Node left;
        Node right;
        int height;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    //Right rotate subtree rooted with y
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        //Perform rotation
        x.right = y;
        y.left = T2;

        //Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        //Return new root
        return x;
    }

    //Left rotate subtree rooted with x
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        //Perform rotation
        y.left = x;
        x.right = T2;

        //Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        //Return new root
        return y;
    }

    //Get balance factor of node N
    public static int getBalance(Node N) {
        if (N == null) {
            return 0;
        }
        return height(N.left) - height(N.right);
    }
    public static Node insert(Node root, int key) {
        //1. Perform the normal BST insert
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            //Duplicate keys not allowed
            return root;
        }

        //2. Update height of this ancestor node
        root.height = 1 + max(height(root.left), height(root.right));

        //3. Get the balance factor
        int balance = getBalance(root);

        //If node becomes unbalanced, then there are 4 cases

        //Left Left Case
        if (balance > 1 && key < root.left.data) {
            return rightRotate(root);
        }

        //Right Right Case
        if (balance < -1 && key > root.right.data) {
            return leftRotate(root);
        }

        //Left Right Case
        if (balance > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //Right Left Case
        if (balance < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        //return the (unchanged) node pointer
        return root;
    }
    //A utility function to print preorder traversal of the tree.
    //The function also prints height of every node
    public static void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public static void main (String args[]){
        root = insert(root, 10);
        root = insert(root, 20);    
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /*
                    30
                   /  \
                 20    40
                / \      \
               10 25     50
        */
        System.out.println("Preorder traversal of the constructed AVL tree is:");
        preOrder(root);
        System.out.println();
    }
}
