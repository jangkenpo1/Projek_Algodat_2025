public class nodeGraph {
    String nomorBangunan;
    String jenisBangunan;
    nodeEdge headEdge;
    nodeGraph next;
    
    public nodeGraph(String nomorBangunan, String jenisBangunan) {
        this.nomorBangunan = nomorBangunan;
        this.jenisBangunan = jenisBangunan;
        this.headEdge = null;
        this.next = null;
    }
}
