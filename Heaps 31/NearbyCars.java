import java.util.*;

public class NearbyCars {

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distance;
        int index;

        Point(int x, int y, int index){
            this.x = x;
            this.y = y;
            this.distance = x*x + y*y; //squared distance from origin
            this.index = index;
        }

        @Override
        public int compareTo(Point p2){
            return this.distance - p2.distance; //min-heap based on distance
        }
    }

    public static void main(String args[]){
        int pts[][] = {{3,3},{5,-1}, {-2,4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0; i<pts.length; i++){
            Point p = new Point(pts[i][0], pts[i][1], i);
            pq.add(p);
        }

        //retrieve k nearest points 
        for(int i=0; i<k; i++){
            System.out.println("Point " + (i+1) + ": (" + pq.peek().x + ", " + pq.peek().y + ")");
            pq.remove();
        }
    }
}