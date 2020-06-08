import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.io.*;
public class Graph{
    private int vertexCount, edgeCount;
    boolean directed; // false for undirected graphs, true for directed
    String[] path;

       private boolean adj[][];//our ajacency matrix array

       public Graph(int numVertices, boolean isDirected){
        this.vertexCount = numVertices;
        this.directed = isDirected;
        adj = new boolean[vertexCount][vertexCount];
       }

       public boolean isDirected() {
        return directed;
       } // your code here }
       public int vertices() { 
            return vertexCount;
       }// return the number of vertices }
       public int edges() {
            return edgeCount;
       } // return number of edges }
       public void insert(Edge e) { 
           edgeCount++;
           adj[e.v][e.w] = true;
           

           if(isDirected() ==false){
            adj[e.w][e.v] = true;
        }
          

       }// your code here }
       public void delete(Edge e) {
           edgeCount--;
        adj[e.v][e.w] = false;

        if(isDirected() == false){
         adj[e.w][e.v] = false;
        }


       } 

       public void printGraph(){
           for(int i=0; i<vertexCount;i++){
               for(int j = 0; j<vertexCount;j++){
                   System.out.print(adj[i][j]);
               }
               System.out.println();
           }
       }

       public void show () {
        for (int s = 0; s < vertices(); s++) {
        System.out.print(s + ": ");
        AdjList A = getAdjList(s);
        for (int t = A.begin(); !A.end(); t = A.next()) // use of iterator
        System.out.print(t + " ");
        System.out.println();
        }
       }

       public void unweighted (int s){
            int [] distTo = new int[vertices()];
            boolean [] known = new boolean[vertices()];
            path = new String[vertices()];

            for (int i=0;i<vertices();i++){
                distTo[i] = Integer.MAX_VALUE;
                known[i] = false;
            }
            distTo[s] = 0;
            for(int currdist = 0; currdist<vertices();currdist++){
                for (int i = 0; i<vertices();i++){
                    if(!known[i] && distTo[i] == currdist){
                        known[i] = true;

                        for(int w=0; w<vertices();w++){
                            if((connected(i, w)== true) && distTo[w] == Integer.MAX_VALUE){
                                distTo[w] = currdist+1;
                                path[w] = Integer.toString(i);
                            }
                        }
                    }
                }
            }
       }

       public void printPath(int p){
           if(path[p]==null){
               System.out.println("0");
               return;
           }
           ArrayList<String>storePath = new ArrayList<>();
           storePath.add(Integer.toString(p));
           storePath.add(path[p]);

           int x = Integer.parseInt(path[p]);
                while(path[x]!=null){
                    storePath.add(path[x]);
                    x = Integer.parseInt(path[x]);
                }
                for(int i=storePath.size()-1;i>=0;i--){
                    System.out.println(storePath.get(i));
                }
       }

       public static Graph createFromFile (String filename) throws Exception {

           // File newFile = new File(filename);
            Scanner scan = new Scanner(new File(filename));
            boolean b;
            int numVert = scan.nextInt();
            //Graph.vertexCount = Integer.parseInt(scan.next());
            String checkDirected = scan.next();
            if(checkDirected.equalsIgnoreCase("U")){
                b = false;
            }else{
                b = true;
            }
            Graph myGraph = new Graph(numVert, b);

            while (scan.hasNext()){
                Edge e = new Edge(scan.nextInt(), scan.nextInt());
                myGraph.insert(e);

            }
            return myGraph;

       }


       public boolean connected(int node1, int node2) {
           if(isDirected()==false){
                if((adj[node1][node2] == true) && (adj[node2][node1]==true)){
                    return true;
                }
           }
            return adj[node1][node2];
       } 
       public AdjList getAdjList(int vertex) {
        //ArrayList<? extends Comparable> AdjList = new ArrayList<>();
            return new AdjArray(vertex);

       } 
       //main method here
       public static void main(String args[]) throws Exception { 
           Graph g = createFromFile(args[0]);
           System.out.println("Graph: ");
           g.show();
           System.out.println(g.vertices());
           System.out.println("here is the path from initial to final vertex");
           g.unweighted(1);
           g.printPath(4);

           

        //    Graph Directed = new Graph(7,true);
        //    Edge e1 = new Edge(0,1);
        //    Edge e2 = new Edge(2,0);
        //    Edge e3 = new Edge(2,5); 
        //    Edge e4 = new Edge(3,2);
        //    Edge e5 = new Edge(0,3);
        //    Edge e6 = new Edge(1,3);
        //    Edge e7 = new Edge(1,4);
        //    Edge e8 = new Edge(3,4);
        //    Edge e9 = new Edge(3,5);
        //    Edge e10 = new Edge(3,6);
        //    Edge e11 = new Edge(6,5);
        //    Edge e12 = new Edge(4,6);
        //    Directed.insert(e1);
        //    Directed.insert(e2);
        //    Directed.insert(e3);
        //    Directed.insert(e4);
        //    Directed.insert(e5);
        //    Directed.insert(e6);
        //    Directed.insert(e7);
        //    Directed.insert(e8);
        //    Directed.insert(e9);
        //    Directed.insert(e10);
        //    Directed.insert(e11);
        //    Directed.insert(e12);

        //     System.out.println("Here is the directed graph");
        //     System.out.println("-------------------------------");

        //    Directed.show();
        //    //end of the directed graph

            
        //    Graph Undirected = new Graph(5, false);
        //    Edge u1 = new Edge(0,1);
        //    Edge u2 = new Edge(1,2);
        //    Edge u3 = new Edge(1,3);
        //    Edge u4 = new Edge(0,4);
        //    Edge u5 = new Edge(2,4);
        //    Edge u6 = new Edge(0,3);
        //    Edge u7 = new Edge(3,2);
        //    Undirected.insert(u1);
        //    Undirected.insert(u2);
        //    Undirected.insert(u3);
        //    Undirected.insert(u4);
        //    Undirected.insert(u5);
        //    Undirected.insert(u6);
        //    Undirected.insert(u7);

        //    System.out.println("Here is the undirected graph");
        //     System.out.println("-------------------------------");

        //    Undirected.show();

        //    System.out.println("The Third Graph is");
        //    System.out.println("-------------------------------");
        // Graph g3=new Graph(9,true);
        // Edge eee1=new Edge(8,7);
        // Edge eee2=new Edge(7,6);
        // Edge eee3=new Edge(6,5);
        // Edge eee4=new Edge(5,4);
        // Edge eee5=new Edge(4,3);
        // Edge eee6=new Edge(3,2);
        // Edge eee7=new Edge(2,1);
        // Edge eee8=new Edge(1,0);


        // g3.insert(eee1);
        // g3.insert(eee2);
        // g3.insert(eee3);
        // g3.insert(eee4);
        // g3.insert(eee5);
        // g3.insert(eee6);
        // g3.insert(eee7);
        // g3.insert(eee8);
        
        // g3.show();
        // System.out.println("-------------------------------");

       }

      

       interface AdjList{
           int begin();
           int next();
           boolean end();
       }

       private class AdjArray implements AdjList {
        private int v; //what vertex are we interested in
        private int w; //keep track of where we are
        private int i;
        public AdjArray(int v){
            //write some stuff here
            this.v=v;
            this.w =w;
            i = -1;
        }
        public int next(){
            // use a for loop to advance the value of “i”
            for (++i; i < vertices(); i++){
                if (connected(v,i) == true) return i;
            }
            return -1;
            // and search the appropriate row return the index
            // of the next true value found
            // “if (connected(v,i) == true) return i;”
            // if the loop completes without finding anything return -1
        }
        public int begin(){
            //reset "i" back to -1
            i=-1;
            // return a value of a call to "next"
            return next();
        }
        public boolean end(){
            //if "i" is less than the number of vertices then return false
            if(i<vertices()){ return false;}
               

            return true;
        
        }
       }
}