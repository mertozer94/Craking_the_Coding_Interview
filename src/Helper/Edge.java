package Helper;

/**
 * @author Mert Ozer
 */
public class Edge {

    public int id;
    public State state;
    public enum State { Unvisited, Visited, Visiting; }

    public Edge(int i){
        this.id = i;
        state = State.Unvisited;
    }

    @Override
    public String toString() {
        return Integer.toString(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == Edge.class.cast(obj).id;
    }
}
