import java.util.*;

public class PriorityQueue1 {

  //PQ for objects
  static class Student{
    String name;
    int rank;

    Student(String name, int rank){
        this.name = name;
        this.rank = rank;
    }
     // Comparator for Student objects based on rank 
  public int compareTo (Student s2){
    return this.rank - s2.rank; //min-heap
  }
 
  }

  public static void main(String args[]){
      PriorityQueue<Student> pq = new PriorityQueue<>();
      
        pq.add(new Student("A", 4)); //O(log n)
        pq.add(new Student("B", 5));
        pq.add(new Student("C", 3));
        pq.add(new Student("D", 12));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + " " + pq.peek().rank); //O(1)
            pq.remove(); //O(log n)
        }   
}
}