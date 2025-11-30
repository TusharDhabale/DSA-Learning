import java.util.*;

public class CycleDetectionInDirected {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;

        }
    }
    // static void createGraph(ArrayList<Edge>[] graph) {
    //     for (int i = 0; i < graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }

    //     // 0th vertex
    //     graph[0].add(new Edge(0, 2));

    //     // 1st vertex
    //     graph[1].add(new Edge(1, 0));

    //     // 2nd vertex
    //     graph[2].add(new Edge(2, 3));

    //     // 3rd vertex
    //     graph[3].add(new Edge(3, 0));
    // }

    //Graph2 - false

    static void createGraph2(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0th vertex
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // 1st vertex
        graph[1].add(new Edge(1, 3));

        // 2nd vertex
        graph[2].add(new Edge(2, 3));

        // 3rd vertex
        // no edges
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        boolean recStack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (isCycleUtil(graph, i, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean visited[], boolean recStack[]) {
        visited[curr] = true;
        recStack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (recStack[e.dest]) {
                return true;
            } else if (!visited[e.dest]) {
                if (isCycleUtil(graph, e.dest, visited, recStack)) {
                    return true;
                }
            }
        }
        recStack[curr] = false;
        return false;
    }

    public static void main (String args[]){

        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycle(graph));

    }
}