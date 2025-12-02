public class main {
    public static void main(String[] args) {
    methodGraph graph = new methodGraph(null);

    graph.addNode("A1", "Gedung");
    graph.addNode("B2", "SPBU");

    graph.doubleaddEdge("A1", "B2", 10);

    }
}
