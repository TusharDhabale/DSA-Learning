import java.util.*;

public class ConnectingCitiesMinCost {

    static class Edge implements Comparable<Edge> {
        int src;
        int cost;

        public Edge(int s, int c) {
            this.src = s;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost;
        }
    }
    public static int connectingCities(int cities[][]){
       PriorityQueue<Edge> pq = new PriorityQueue<>();
       boolean vis[] = new boolean[cities.length];

         pq.add(new Edge(0,0));
            int finalCost = 0;

            while(!pq.isEmpty()){
                Edge curr = pq.remove();
                if(!vis[curr.src]){
                    vis[curr.src] = true;
                    finalCost += curr.cost;

                    for(int j=0;j<cities.length;j++){
                        if(cities[curr.src][j]!=0 && !vis[j]){
                            pq.add(new Edge(j, cities[curr.src][j]));
                        }
                    }
                }
            }
            return finalCost;
    }
    public static void main (String[] args){
        int cities[][] = { {0, 1, 2, 3, 4},
                            {1, 0, 5, 0, 7},
                            {2, 5, 0, 6, 0},
                            {3, 0, 6, 0, 4},
                            {4, 7, 0, 4, 0} };

        int cost = connectingCities(cities);
        System.out.println("Minimum cost to connect all cities: "+cost);
        

        }
    }


