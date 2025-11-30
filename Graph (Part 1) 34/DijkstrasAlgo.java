import java.util.*;

public class DijkstrasAlgo {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair>{
        int node;
        int pathCost;

        public Pair(int n, int pc){
            this.node = n;
            this.pathCost = pc;
        }

        @Override
        public int compareTo(Pair p2){
            return this.pathCost - p2.pathCost; //ascending order
        }
    }

    static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        //0th vertex
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        //1st vertex
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        //2nd vertex
        graph[2].add(new Edge(2, 4, 3));

        //3rd vertex
        graph[3].add(new Edge(3, 5, 1));

        //4th vertex
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
    public static void dijkstra(ArrayList<Edge>[] graph, int src){
        int V = graph.length;
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        boolean visited[] = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();

            if(!visited[curr.node]){
                visited[curr.node] = true;

                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        //print shortest distance from source to all vertices
        for(int i=0; i<dist.length; i++){
            System.out.println("Distance from source " + src + " to vertex " + i + " is: " + dist[i]);
        }
    }

    public static void main (String args[]){
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        dijkstra(graph, 0);
    }
}
