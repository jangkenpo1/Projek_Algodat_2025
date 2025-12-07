public class nodeEdge {
    String destination;
    String namaJalan;
    int weight;
    nodeEdge next;

    public nodeEdge(String destination, String namaJalan, int weight) {
        this.destination = destination;
        this.namaJalan = namaJalan;
        this.weight = weight;
        this.next = null;
    }
}
