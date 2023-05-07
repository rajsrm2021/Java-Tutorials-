import java.util.ArrayList;

public class Graph1 {
    static class Edge {
        int src;
        int dst;
        int wt;

        Edge(int scr, int dst, int wt) {
            this.src = src;
            this.dst = dst;
            this.wt = wt;

        }
    }

    public static void main(String args[]) {
        /*
         *      (5)
         * 0-------------- 1
         *                / \
         *           (1) /   \ (3)
         *              /     \
         *             2-- -----3
         *             |  (4)
         *         (2) |
         *             |
         *             4
         */

        // total verties
        int v = 5;
        // int arr[]=new arr[size];
        ArrayList<Edge>[] graph = new ArrayList[v]; // null -> empty
        // graph naam ka array hai , jisme data arrayList hai of typr edges;
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0-vertex
        graph[0].add(new Edge(0, 1, 5));

        // 1-vertex
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2-vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 4));
        graph[2].add(new Edge(2, 4, 2));

        // 3-vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 2, 4));

        // 4-vertex
        graph[4].add(new Edge(4, 2, 2));

        // 2's neighbour print
        for(int i=0;i<graph[2].size();i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dst);
        }
    }
}
