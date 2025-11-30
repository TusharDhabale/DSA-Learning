import java.util.*;

public class TopologicalSorting {
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

        graph[0].add(new Edge(0, 3));
        
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        }

        //Using DFS

        // public static void topSort(ArrayList<Edge>[] graph) {
        //     boolean visited[] = new boolean[graph.length];
        //     Stack<Integer> s = new Stack<>();

        //     for (int i = 0; i < graph.length; i++) {
        //         if (!visited[i]) {
        //             topSortUtil(graph, i, visited, s);
        //         }
        //     }

        //     while (!s.isEmpty()) {
        //         System.out.print(s.pop() + " ");
        //     }
        // }

        // public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean visited[], Stack<Integer> s) {
        //     visited[curr] = true;

        //     for (int i = 0; i < graph[curr].size(); i++) {
        //         Edge e = graph[curr].get(i);
        //         if (!visited[e.dest]) {
        //             topSortUtil(graph, e.dest, visited, s);
        //         }
        //     }
        //     s.push(curr);
        // }

        //Using BFS (Kahn's Algorithm)

        public static void calcIndeg(ArrayList<Edge>[] graph, int indeg[]) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    indeg[e.dest]++;
                }
            }
        }
        public static void topSort(ArrayList<Edge>[] graph) {
            int indeg[] = new int[graph.length];
            calcIndeg(graph, indeg);

            Queue<Integer> q = new LinkedList<>();

            // add vertices with 0 indegree
            for (int i = 0; i < indeg.length; i++) {
                if (indeg[i] == 0) {
                    q.add(i);
                }
            }

            //bfs
            while (!q.isEmpty()) {
                int curr = q.remove();
                System.out.print(curr + " ");

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    indeg[e.dest]--;
                    if (indeg[e.dest] == 0) {
                        q.add(e.dest);
                    }
                }
            }
        }

        //All path from source to destination
        public static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, String path) {
            if (src == dest) {
                System.out.println(path + dest);
                return;
            }

            for (int i = 0; i < graph[src].size(); i++) {
                Edge e = graph[src].get(i);
                printAllPath(graph, e.dest, dest, path + src);
            }
        }
        public static void main (String args[]){

            int V = 6;
            ArrayList<Edge>[] graph = new ArrayList[V];
            createGraph(graph);
            topSort(graph);

            int src = 5;
            int dest = 1;
            printAllPath(graph, src, dest, "");

        }
    }