import java.util.*;

public class HashSett {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        // Adding elements
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2); 
        set.add(1);
        
        System.out.println("HashSet: " + set);

        if(set.contains(2)){
            System.out.println("Set contains 2");
        }
        if(set.contains(3)){
            System.out.println("Set contains 3");
        } else {
            System.out.println("Set does not contain 3");
        }

    }
}
