import java.util.*;

public class BFSAndDFSAndHasPath {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0th vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1st vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2nd vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3rd vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4th vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5th vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6th vertex
        graph[6].add(new Edge(6, 5, 1));
    }

    //Connected Components

    public static void bfs(ArrayList<Edge>[] graph ){
        boolean visited[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                bfsUtil(graph);
            }
        }
    }

    // BFS Implementation
    public static void bfsUtil(ArrayList<Edge>[] graph) {
        // boolean visited[] = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();

        q.add(0); // starting from vertex 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    //Connected Components
    public static void dfs(ArrayList<Edge>[] graph) {
       boolean visited[] = new boolean[graph.length];
       for(int i=0; i<graph.length; i++){
         dfsUtil(graph, i, visited);
    }

    // DFS Implementation
    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean visited[]) {
        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfsUtil(graph, e.dest, visited);
            }
        }
    }

    //Has path implementation
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean visited[]) {
        if (src == dest) {
            return true;
        }

        visited[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!visited[e.dest]) {
                if (hasPath(graph, e.dest, dest, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Main method
    public static void main (String args[]){
        /*
                 1 --- 3
                /      | \
               0       |  5 -- 6
                \      | /
                 2 --- 4
                    
        */

        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        // bfs(graph);

        // System.out.println(); 
        // dfs(graph, 0, new boolean[V]);

        // System.out.println();
        // System.out.println(hasPath(graph, 0, 5, new boolean[V]));
    }
}
