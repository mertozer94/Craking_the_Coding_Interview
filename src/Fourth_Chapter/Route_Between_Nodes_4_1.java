package Fourth_Chapter;
import Helper.Edge;
import Helper.Graph;


import java.util.LinkedList;

/**
 * @author Mert Ozer
 * Given a directed graph, design an algorithm to find out whether there is a
route between two nodes
 */
public class Route_Between_Nodes_4_1 {
    public static void main(String[] args){
        Graph g = new Graph().createGraph();
        g.printGraph();
        System.out.println(search(g,g.getEdge(1),g.getEdge(2)));
        g.emptyStates();
        System.out.println(search(g,g.getEdge(3),g.getEdge(0)));
        g.emptyStates();
        System.out.println(search(g,g.getEdge(4),g.getEdge(1)));
    }


    public static boolean search(Graph g, Edge start, Edge end){
        if (start == null || end == null)
            return false;
        if (start.equals(end))
            return true;

        LinkedList<Edge> queue = new LinkedList<>();
        start.state = Edge.State.Visiting;
        queue.add(start);

        while (!queue.isEmpty()){
            Edge edge = queue.removeFirst();
            if (edge != null){
                for (Edge vertex: g.getNeighbours(edge)){
                    if (vertex.state == Edge.State.Unvisited){
                        if (vertex.equals(end))
                            return true;
                        else {
                            vertex.state = Edge.State.Visiting;
                            queue.add(vertex);
                        }
                    }
                }
                edge.state = Edge.State.Visited;
            }
        }
        return false;
    }


}
