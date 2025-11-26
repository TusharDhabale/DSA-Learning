import java.util.*;

public class IterationOnHashSet {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();

        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        // Iterator it = cities.iterator();
        // while(it.hasNext()){
        // System.out.println(it.next());
        // }
        System.out.println("HashSet " + cities);

        LinkedHashSet<String> city = new LinkedHashSet<>();
        city.add("Delhi");
        city.add("Mumbai");
        city.add("Noida");
        city.add("Bengaluru");
        System.out.println("LinkedHashet " + city);

        TreeSet<String> citi = new TreeSet<>();
        citi.add("Delhi");
        citi.add("Mumbai");
        citi.add("Noida");
        citi.add("Bengaluru");
        System.out.println("TreeSet " + citi);
    }
}
