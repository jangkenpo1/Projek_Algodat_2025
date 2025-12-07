public class nodeGraph {
    String nomorBangunan;
    String jenisBangunan;
    nodeEdge headEdge;
    nodeGraph next;
    
    FireReport laporanHead;      
    methodLaporan laporan;    
    
    public nodeGraph(String nomorBangunan, String jenisBangunan) {
        this.nomorBangunan = nomorBangunan;
        this.jenisBangunan = jenisBangunan;
        this.headEdge = null;
        this.next = null;
        this.laporanHead = null;
        this.laporan = null;  // Default null, set manual main P1
    }
}
