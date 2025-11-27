import java.util.*;

public class PrefixProblem {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        public Node () {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 0;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
            curr.freq++;
        }
        curr.eow = true;
    }

    public static void findPrefix(Node node, String ans) {
        if (node == null) {
            return;
        }
        if (node.freq == 1) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                findPrefix(node.children[i], ans + (char)(i + 'a'));
            }
        }
    }

public static void main(String[] args) {
    String arr[] = {"zebra", "dog", "duck", "dove"};

    for (int i = 0; i < arr.length; i++) {
        insert(arr[i]);
    }

    findPrefix(root, "");

    
}
}