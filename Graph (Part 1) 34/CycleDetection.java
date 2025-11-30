import java.util.*;

public class CycleDetection {
    static class Edge {
        int src;
        int dest;
        
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
            
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0th vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // 1st vertex
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        
        // 2nd vertex
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        // 3rd vertex
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        // 4th vertex
        graph[4].add(new Edge(4, 3));
      
    }

    // Detect Cycle in an Undirected Graph using DFS

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(graph, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, int curr, boolean visited[], int parent) {
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // Case 1: If the neighbor is not visited
            if (!visited[e.dest]) {
                if (detectCycleUtil(graph, e.dest, visited, curr)) {
                    return true;
                }
            }
            // Case 2: If the neighbor is visited and is not the parent
            else if (e.dest != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        /*
              0 --------3
            / |         |
           /  |         |
          1   |         |
           \  |        4
            \ 2

                 */

        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCycle(graph));
}
}