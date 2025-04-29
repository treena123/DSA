package algopractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author trinapal
 */
public class DFSUsingLib {
    private static int V;
    // Array of lists for
    // Adjacency List Representation
    private LinkedList<Integer> adj[];
    @SuppressWarnings("unchecked")
    DFSUsingLib(int V){
        this.V= V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i)
            adj[i] = new LinkedList();
    }
    public static void main(String[] args) {
        DFSUsingLib g = new DFSUsingLib(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        //traverse the list from 2
        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");
        boolean [] visited = new boolean[V];

        g.DFS(2,visited);


    }

    private  void DFS(int source, boolean [] visited) {
        //mark the suce visited
        visited[source] = true;
        System.out.println(" " + source);
        Iterator<Integer> i = adj[source].listIterator();
        while(i.hasNext()){
            int next = i.next();
            if(!visited[next]){
                DFS(next,visited);
            }
        }

    }

    private void addEdge(int start, int end) {
        adj[start].add(end);
        adj[end].add(start);// for undirected graph, for directed graph, it is not needed
    }
}
