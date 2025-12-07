public class main {
    public static void main(String[] args) {
        methodGraph graph = new methodGraph(null);

        // NODE PEMADAM
        graph.addNode("P1", "Pemadam");

        // NODE PERSIMPANGAN
        graph.addNode("S1", "Persimpangan Gatot Subroto");
        graph.addNode("S2", "Persimpangan Ahmad Yani");
        graph.addNode("S3", "Persimpangan Sudirman");
        graph.addNode("S4", "Persimpangan Thamrin");
        graph.addNode("S5", "Persimpangan Merdeka");
        graph.addNode("S6", "Persimpangan Diponegoro");
        graph.addNode("S7", "Persimpangan Veteran");

        // NODE BANGUNAN 
        graph.addNode("B1", "Rumah Sakit");
        graph.addNode("B2", "SPBU");
        graph.addNode("B3", "Gedung Bertingkat");
        graph.addNode("B4", "Sekolah");
        graph.addNode("B5", "Pabrik Industri");
        graph.addNode("B6", "Rumah tinggal");
        graph.addNode("B7", "Apartemen");
        graph.addNode("B8", "Rumah tinggal");
        graph.addNode("B9", "Lahan kosong");
        graph.addNode("B10", "Kendaraan");
        graph.addNode("B11", "Rumah tinggal");
        graph.addNode("B12", "SPBU");
        graph.addNode("B13", "Gedung Bertingkat");
        graph.addNode("B14", "Apartemen");
        graph.addNode("B15", "Sekolah");
        graph.addNode("B16", "Pabrik Industri");
        graph.addNode("B17", "Rumah tinggal");

        
        // P1 (Pemadam)
        graph.doubleaddEdge("P1", "B16", "Jl. Industri", 75);
        graph.doubleaddEdge("P1", "S1", "Jl. Merdeka Barat", 55);
        
        // B1
        graph.doubleaddEdge("B1", "S2", "Jl. Soekarno-Hatta", 65);
        
        // B2
        graph.doubleaddEdge("B2", "S2", "Jl. Pahlawan", 70);
        graph.doubleaddEdge("B2", "B3", "Jl. Kemerdekaan", 85);
        graph.doubleaddEdge("B2", "B6", "Jl. Imam Bonjol", 55);
        
        // B3
        graph.doubleaddEdge("B3", "S3", "Jl. Proklamasi", 75);
        graph.doubleaddEdge("B3", "B9", "Jl. Gatot Subroto", 80);
        graph.doubleaddEdge("B3", "B6", "Jl. Sudirman", 90);
        
        // B4
        graph.doubleaddEdge("B4", "S3", "Jl. Kartini", 95);
        graph.doubleaddEdge("B4", "B10", "Jl. Letjen Suprapto", 90);
        graph.doubleaddEdge("B4", "S7", "Jl. Pierre Tendean", 95);
        
        // B5
        graph.doubleaddEdge("B5", "S2", "Jl. Pemuda", 60);
        graph.doubleaddEdge("B5", "B11", "Jl. Cut Nyak Dien", 75);
        
        // B6
        graph.doubleaddEdge("B6", "B8", "Jl. Teuku Umar", 70);
        
        // B7
        graph.doubleaddEdge("B7", "S2", "Jl. Asia Afrika", 80);
        graph.doubleaddEdge("B7", "B11", "Jl. Kebon Jeruk", 70);
        
        // B8
        graph.doubleaddEdge("B8", "B9", "Jl. Basuki Rahmat", 60);
        graph.doubleaddEdge("B8", "B11", "Jl. Naik Haji", 75);
        
        // B9
        graph.doubleaddEdge("B9", "B10", "Jl. Supratman", 70);
        
        // B10
        graph.doubleaddEdge("B10", "S6", "Jl. Wolter Monginsidi", 75);
        
        // B11
        // Sudah ditambahkan di B5, B7, dan B8
        
        // B12
        graph.doubleaddEdge("B12", "S1", "Jl. Majapahit", 70);
        graph.doubleaddEdge("B12", "S4", "Jl. Pemuda Raya", 75);
        graph.doubleaddEdge("B12", "14", "Jl. Mawar Satu", 60);
        graph.doubleaddEdge("B12", "16", "Jl. Mawar Dua", 70);
        
        // B13
        graph.doubleaddEdge("B13", "S6", "Jl. Pattimura Mundur", 80);
        graph.doubleaddEdge("B13", "S6", "Jl. Pattimura Maju", 55);
        
        // B14
        graph.doubleaddEdge("B14", "B16", "Jl. Anggrek", 55);
        
        // B15
        graph.doubleaddEdge("B15", "S6", "Jl. Tulip", 70);
        
        // B16
        graph.doubleaddEdge("B16", "S5", "Jl. Flamboyan", 70);
        
        // B17
        graph.doubleaddEdge("B17", "S7", "Jl. Hos Cokroaminoto", 100);
        graph.doubleaddEdge("B17", "S5", "Jl. Dahlia", 85);
        
        // S1
        graph.doubleaddEdge("S1", "S2", "Jl. Jenderal Sudirman", 60);
        
        // S4
        graph.doubleaddEdge("S4", "S3", "Jl. Melati", 90);
        graph.doubleaddEdge("S4", "S5", "Jl. Kenanga", 75);
        graph.doubleaddEdge("S4", "S6", "Jl. Veteran Raya", 80);

    }
}
