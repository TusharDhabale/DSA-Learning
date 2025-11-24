import java.util.*;

public class ConnectNRopes {

    
    public static void main(String args[]){
        int ropes[] = {4, 3, 2, 6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //add all ropes to min-heap
        for(int i=0; i<ropes.length; i++){
            pq.add(ropes[i]);
        }

        int cost = 0;
        //while more than one rope is there
        while(pq.size() > 1){
            //step1: remove two smallest ropes
            int first = pq.remove();
            int second = pq.remove();

            //step2: connect them
            int sum = first + second;
            cost += sum;

            //step3: add the resultant rope back to min-heap
            pq.add(sum);
        }

        System.out.println("Total cost for connecting ropes: " + cost);
    }
}