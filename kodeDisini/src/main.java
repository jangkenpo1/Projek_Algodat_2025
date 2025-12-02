public class main {
    public static void main(String[] args) {
    methodGraph graph = new methodGraph(null);

    graph.addNode("A1", "Gedung");
    graph.addNode("B2", "SPBU");
    graph.addNode("C3", "Rumah");
    graph.addNode("D4", "Pabrik");
    graph.addNode("E5", "Apartemen");

    graph.doubleaddEdge("A1", "B2", 10);
    graph.doubleaddEdge("A1", "C3", 5);
    graph.doubleaddEdge("B2", "D4", 15);
    graph.doubleaddEdge("C3", "E5", 7);
    graph.doubleaddEdge("D4", "E5", 12);
    }
}
