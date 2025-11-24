import java.util.*;

public class WeakestSoldier {

    static class Row implements Comparable<Row>{
        int soldiers;
        int index;

        Row(int soldiers, int index){
            this.soldiers = soldiers;
            this.index = index;
        }

        @Override
        public int compareTo(Row r2){
           if(this.soldiers == r2.soldiers){
               return this.index - r2.index; //min-heap based on index if soldiers are equal
           }
           return this.soldiers - r2.soldiers; //min-heap based on soldiers count
        }
    }
    public static void main(String args[]){
        int army[][] = {
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,1,0,0}
    };
        int k = 2;

        PriorityQueue<Soldier> pq = new PriorityQueue<>();
        for(int i=0; i<army.length; i++){
            int soldiersCount = 0;
            for(int j=0; j<army[i].length; j++){
                soldiersCount += army[i][j];
            }
            Soldier s = new Soldier(soldiersCount, i);
            pq.add(s);
        }

        //retrieve k weakest soldiers
        for(int i=0; i<k; i++){
            System.out.println("Soldier " + (i+1) + ": Row " + pq.peek().index);
            pq.remove();
        }
    }
}