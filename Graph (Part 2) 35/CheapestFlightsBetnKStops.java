import java.util.*;

public class CheapestFlightsBetnKStops {

    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    static class Info {
        int node;
        int cost;
        int stops;

        public Info(int n, int c, int s) {
            this.node = n;
            this.cost = c;
            this.stops = s;
        }
    }
    public static void createGraph(int flights[][], ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

       for(int i=0;i<flights.length;i++){
           int u = flights[i][0];
           int v = flights[i][1];
           int w = flights[i][2];

           Edge e = new Edge(u,v,w);
           graph[u].add(e);
       }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0)); // {node, cost, stops}

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                continue;
            }

            for (int i = 0; i < graph[curr.node].size(); i++) {
                Edge e = graph[curr.node].get(i);
                int v = e.dest;
                int w = e.weight;

                if (curr.cost + w < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + w;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

       //dist[dst]
       if(dist[dst]==Integer.MAX_VALUE){
           return -1;
       }
       else{
           return dist[dst];
       }
    }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0, dst = 3, k = 1;
        int cost = findCheapestPrice(n, flights, src, dst, k);
        System.out.println(cost);
    }
}

