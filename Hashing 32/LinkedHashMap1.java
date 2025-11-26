import java.util.*;

public class LinkedHashMap1 {
    public static void main(String args[]) {
        // Create a LinkedHashMap
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("USA", 50);
        
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("USA", 50);

        System.out.println("LinkedHashMap: " + lhm);
        System.out.println("HashMap: " + hm);
    }
}
