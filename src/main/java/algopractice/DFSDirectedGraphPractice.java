package algopractice;

import java.util.ArrayList;

/**
 * @author trinapal
 */
public class DFSDirectedGraphPractice {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i= 0; i<V; i++){
            adjList.add(new ArrayList<>());
        }
        // Define the edges of the graph
        int[][] edges = {
                { 1, 2 }, { 1, 0 }, { 2, 0 }, { 2, 3 }, { 2, 4 }
        };
        //populate neighbors
        for(int [] i: edges){
            addEdge(adjList, i[0],i[1]);
        }
        int source = 1;
        System.out.println("DFS from source: " + source);
        ArrayList<Integer> res = DFS(adjList, source);
        for (int node : res) {
            System.out.print(" " + node);  // ✅ prints actual DFS result
        }
    }

    private static ArrayList<Integer> DFS(ArrayList<ArrayList<Integer>> adjList, int source) {
        boolean [] visited = new boolean[adjList.size()];
        ArrayList<Integer> res = new ArrayList<>();
        if (source < 0 || source >= adjList.size()) return res;

        /*for(int i =0; i<adjList.size();i++){
            if(!visited[i]){
                dfsRec(adjList,visited,source, res); //start from source
            }
        }*/
        dfsRec(adjList,visited,source, res); //start from source
        return res;
    }

    public static ArrayList<Integer> dfsRec(ArrayList<ArrayList<Integer>> adjList, boolean [] visited,
                                            int source, ArrayList<Integer> res){
        //mark the current node true
        visited[source] = true;
        res.add(source); // add the current marked node to the list
        //now check the neighbor
        for(int i : adjList.get(source)){
            if (!visited[i]){
                dfsRec(adjList,visited,i,res);
            }
        }

        return res;

    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adjList, int start, int end){
        adjList.get(start).add(end);
        //adjList.get(end).add(start);
    }
}
