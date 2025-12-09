public class nodeGraph {
    String nomorBangunan;
    String jenisBangunan;
    nodeEdge headEdge;
    nodeGraph next;

    methodLaporan laporan;
    boolean isVisited;
    String perjalanan;

    public nodeGraph(String nomorBangunan, String jenisBangunan) {
        this.nomorBangunan = nomorBangunan;
        this.jenisBangunan = jenisBangunan;
        this.headEdge = null;
        this.next = null;
        this.laporan = null;
        this.isVisited = false;
        this.perjalanan = "";
    }
}
