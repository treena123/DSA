package algopractice;

import java.util.ArrayList;

/**
 * @author trinapal
 */
public class DFSPractice {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer> > adjList = new ArrayList<>();
        //initialize adjacent list
        for(int i = 0; i<V; i++){
            adjList.add(new ArrayList<>());
        }

        int[][] edges= { { 1, 2 },{ 1, 0 },{ 2, 0 },{ 2, 3 },{ 2, 4 } };

        for(int []i : edges){
            addEdge(adjList, i[0], i[1]);
        }

        //traverse the graph
        ArrayList<Integer> arr = dfs(adjList);



        for(int i =0; i< arr.size(); i++){
            System.out.println( " " + arr.get(i));
        }

    }

    private static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adjList) {
       boolean[] visited = new boolean[adjList.size()];
       ArrayList<Integer> res = new ArrayList<>();
       for(int i =0; i<adjList.size(); i++){
           if (!visited[i]) {
               dfsRec(adjList, visited, i, res);
           }
       }
       return res;
    }


    private static ArrayList<Integer> dfsRec(ArrayList<ArrayList<Integer>> adjList, boolean[] visited,
                               int start, ArrayList<Integer> res) {
        visited[start]=true; //marked the current node
        res.add(start);
        //recursive call from start
        for(int i : adjList.get(start)){
            //check if marked
            if(!visited[i]){
                dfsRec(adjList,visited,i,res);
            }

        }
    return res;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adjList, int start, int end) {
        adjList.get(start).add(end);
        adjList.get(end).add(start);
    }


}
