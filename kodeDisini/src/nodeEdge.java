public class nodeEdge {
    String destination;
    int weight;
    nodeEdge next;

    public nodeEdge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
        this.next = null;
    }
}
