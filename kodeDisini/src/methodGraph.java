public class methodGraph {
    nodeGraph head;

    public void UI() {
        System.out.println("\n====================================");
        System.out.println("   Sistem Informasi Kebakaran      ");
        System.out.println("====================================");
        System.out.println("1. Tambah Laporan Kebakaran         ");
        System.out.println("2. Lihat Daftar Laporan (Queue)     ");
        System.out.println("0. Keluar                           ");
        System.out.println("====================================");
    }

    public methodGraph(nodeGraph headNode) {
        this.head = headNode;
    }

    public nodeGraph findNode(String nomorBangunan) {
        nodeGraph current = head;
        while (current != null) {
            if (current.nomorBangunan.equals(nomorBangunan)) {
                return current;
            }
            current = current.next;
        }
        return null; 
    }

    public void addNode(String nomorBangunan, String jenisBangunan) {
        if (findNode(nomorBangunan) != null) return; 

        nodeGraph newNode = new nodeGraph(nomorBangunan, jenisBangunan);
        if (head == null) {
            head = newNode;
        } else {
            nodeGraph current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void doubleaddEdge(String source, String destination, String namaJalan, int weight) {
        addEdge(source, destination, namaJalan, weight);
        addEdge(destination, source, namaJalan, weight);
    }

    public void addEdge(String source, String destination, String namaJalan, int weight) {
        nodeGraph sourceNode = findNode(source);
        if (sourceNode == null) {
            System.out.println("Node " + source + " tidak ditemukan!");
            return;
        }

        nodeEdge newEdge = new nodeEdge(destination, namaJalan, weight);
        
        if (sourceNode.headEdge == null) {
            sourceNode.headEdge = newEdge;
        } else {
            nodeEdge current = sourceNode.headEdge;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newEdge;
        }
    }


}
