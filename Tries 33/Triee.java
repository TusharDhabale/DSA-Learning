import java.util.*;

public class Triee {
static class Node {
    Node children[] = new Node[26];
    boolean eow = false;

    Node () {
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}

// Root
public static Node root = new Node();

// Insert
public static void insert(String word) {
    Node curr = root;
    for (int level = 0; level < word.length(); level++) {
        int idx = word.charAt(level) - 'a';
        if (curr.children[idx] == null) {
            curr.children[idx] = new Node();
        }
        curr = curr.children[idx];
    }
    curr.eow = true;
}

// Search

public static boolean search(String key) {
    Node curr = root;
    for (int level = 0; level < key.length(); level++) {
        int idx = key.charAt(level) - 'a';
        if (curr.children[idx] == null) {
            return false;
        }
        curr = curr.children[idx];
    }
    return curr.eow == true;
}

// Word Break Problem
public static boolean wordBreak(String key) {
    if (key.length() == 0) {
        return true;
    }

    for (int i = 1; i <= key.length(); i++) {
       if(search(key.substring(0, i)) && wordBreak(key.substring(i))) {
        return true;
       }
    }
    return false;
}

// Main method
public static void main(String[] args) {

    // Insert
    // String words[] = {"the", "a", "there", "their", "any", "thee"};
    // for (int i = 0; i < words.length; i++) {
    //     insert(words[i]);
    // }
    // System.out.println(search("the"));
    // System.out.println(search("thor"));

    //Word Break Problem
    String arr[] = {"i", "like", "sam", "sung", "samsung", "mobile", "ice"};

    String key = "ilikesamsung";

    for (int i = 0; i < arr.length; i++) {
        insert(arr[i]);
    }
    System.out.println(wordBreak(key));
}
}
