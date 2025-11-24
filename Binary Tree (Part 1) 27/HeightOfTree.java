public class HeightOfTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //Node count
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
    }

    //Sum of nodes
    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }
    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \  / \
             4  5 6  7
        */
        Node root = new Node(1);
        root.left = new Node(2);    
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // System.out.println("Height of the tree: " + height(root));
        // System.out.println("Number of nodes in the tree: " + countNodes(root));
        System.out.println("Sum of all nodes in the tree: " + sumOfNodes(root));
    }
    
}
