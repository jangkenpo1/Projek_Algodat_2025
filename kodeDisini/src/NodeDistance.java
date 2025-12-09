public class NodeDistance {
    String nodeID;
    int distance;
    NodeDistance next;

    public NodeDistance(String nodeID, int distance) {
        this.nodeID = nodeID;
        this.distance = distance;
        this.next = null;
    }
}
