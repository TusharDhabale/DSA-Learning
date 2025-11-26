import java.util.*;

public class IterationOnHashMap {
    public static void main(String args[]) {
        // Create a HashMap
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("USA", 50);
        hm.put("Indonesia", 70);
        hm.put("Nepal", 5);

        // Iterate over the HashMap
        Set<String> keys = hm.keySet();
       System.out.println(keys);
        for (String key : keys) {
            System.out.println(key + " -> " + hm.get(key));
        }
    }
}
