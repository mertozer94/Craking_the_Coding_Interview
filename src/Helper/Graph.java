package Helper;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Graph {
        public int v;
        public LinkedList<Edge> adjListArray[];
        public Edge getEdge(int id){
            for (int v = 0; v < this.v; v++)
            for (Edge edge:this.adjListArray[v]){
                if (edge.id == id)
                    return edge;
            }
            throw new NoSuchElementException("Vertex is not in the graph");
        }
        public Graph(){
            this.v = 5;

            adjListArray = new LinkedList[v];

            for(int i = 0; i < v ; i++){
                adjListArray[i] = new LinkedList<>();
            }
        }

        public void addEdge(Graph graph, Edge src, Edge dest){

            graph.adjListArray[Integer.parseInt(src.toString())].addFirst(dest);
            graph.adjListArray[Integer.parseInt(dest.toString())].addFirst(src);
        }

        public LinkedList<Edge> getNeighbours(Edge edge){
            for(int v = 0; v < this.v; v++){
                if (v == edge.id){
                    return this.adjListArray[v];
                }
            }
            throw new NoSuchElementException("Vertex is not in the graph");
        }
        public void emptyStates(){
            for(int v = 0; v < this.v; v++){
                for (Edge e:this.adjListArray[v]){
                    e.state= Edge.State.Unvisited;
                }
            }
        }
        public void printGraph(){
            for(int v = 0; v < this.v; v++)
            {
                System.out.println("Adjacency list of vertex "+ v);
                System.out.print(v + "(head)");
                for(Edge pCrawl: this.adjListArray[v]){
                    System.out.print(" -> "+pCrawl.toString());
                }
                System.out.println("\n");
            }
        }
        public Graph createGraph(){
            Graph graph = new Graph();
            Edge zero = new Edge(0);
            Edge one = new Edge(1);
            Edge two = new Edge(2);
            Edge three = new Edge(3);
            Edge four = new Edge(4);
            addEdge(graph, zero, one);
            addEdge(graph, zero, four);
            addEdge(graph, one, two);
            addEdge(graph, one, three);
            addEdge(graph, one, four);
            addEdge(graph, two, three);
            addEdge(graph, three, four);
            return graph;
        }
}