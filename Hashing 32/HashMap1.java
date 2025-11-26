import java.util.*; 

public class HashMap1{
    public static void main(String args[]){
        //create a HashMap
        HashMap<String, Integer> map = new HashMap<>();
        
        //Insert
        map.put("India", 100);
        map.put("China", 150);
        map.put("USA", 50);

        System.out.println("Initial Map: " + map);

        //get - 0(1)
        int population = map.get("India");
        System.out.println("Population of India: " + population);

        //containsKey - O(1)
        boolean hasChina = map.containsKey("China");
        System.out.println("Map has China: " + hasChina);
        //containsValue - O(n)
        boolean hasPopulation50 = map.containsValue(50);
        System.out.println("Map has population 50: " + hasPopulation50);
        //remove - O(1)
        map.remove("USA");
        System.out.println("Map after removing USA: " + map);
        //size - O(1)
        int size = map.size();
        System.out.println("Size of the map: " + size);
        //iterate
        System.out.println("Iterating over map:");
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());

        }   
        //Is Empty - O(1)
        map.clear();
        System.out.println("Is map empty after clear? " + map.isEmpty());
    }
}