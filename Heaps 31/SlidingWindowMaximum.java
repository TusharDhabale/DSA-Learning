import java.util.*;

public class SlidingWindowMaximum {

    static class Pair implements Comparable<Pair>{
        int value;
        int index;

        Pair(int value, int index){
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair p2){
            return p2.value - this.value; //max-heap
        }
    }

    public static void main(String args[]){
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int res[] = new int[arr.length - k + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        //add first k elements to pq
        for(int i=0; i<k; i++){
            pq.add(new Pair(arr[i], i));
        }
        res[0] = pq.peek().value;
        //process remaining elements
        for(int i=k; i<arr.length; i++){
            //remove elements not part of window
            while(!pq.isEmpty() && pq.peek().index <= i - k){
                pq.remove();
            }
            //add current element
            pq.add(new Pair(arr[i], i));
            //get max for current window
            res[i - k + 1] = pq.peek().value;
        }
        //print result
        for(int i=0; i<res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
}