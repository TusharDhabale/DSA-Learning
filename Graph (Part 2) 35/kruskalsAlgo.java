import java.util.*;

public class kruskalsAlgo {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.weight - e2.weight;
        }
    }
    static void createGraph(ArrayList<Edge> edges){
        //adding edges
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    } 

    static int n = 4;
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
    }
    public static int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rank[rootA]<rank[rootB]){
            parent[rootA] = rootB;
        }
        else if(rank[rootB]<rank[rootA]){
            parent[rootB] = rootA;
        }
        else{
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
    public static void kruskalsMST(ArrayList<Edge> edges){
        Collections.sort(edges);
        init();
       int mstCost = 0;
       int count = 0;

      for(int i=0; count<n-1; i++){
          Edge e = edges.get(i);
          //(src, dest, weight)}

          int parA = find(e.src);
          int parB = find(e.dest);
            if(parA!=parB){
                union(e.src, e.dest);
                mstCost += e.weight;
                count++;
               
            }
    }
        System.out.println("MST cost: "+mstCost);
    }
    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalsMST(edges);
    }
}