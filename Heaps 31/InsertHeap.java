import java.util.*;

public class InsertHeap {

    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            //add at last index
            arr.add(data);
            int x = arr.size() - 1; //child index
            int par = (x - 1) / 2; //parent index
            while (x > 0 && arr.get(x) < arr.get(par)) {
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        //heapify

        private void heapify(int i){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)){
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }

            if(minIdx != i){
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        //remove
        public int remove(){
            int data = arr.get(0);
            //step1: swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            //step2: remove last
            arr.remove(arr.size() - 1);

            //step3: heapify
            heapify(0);
            return data;
        }

        public int peek(){
            return arr.get(0);
        }

        public boolean isEmpty(){
            return arr.isEmpty();
        }
    }

    public static void main(String args[]){
        Heap heap = new Heap();
        heap.add(3);
        heap.add(4);
        heap.add(1);
        heap.add(5);
        System.out.println("Peek: " + heap.peek());
        System.out.println("Removed: " + heap.remove());
        System.out.println("Peek after remove: " + heap.peek());
    }
}


