public class NodeQueue {
    String nodeID;
    int priority;
    NodeQueue next;

    public NodeQueue(String nodeID, int priority) {
        this.nodeID = nodeID;
        this.priority = priority;
        this.next = null;
    }
}
