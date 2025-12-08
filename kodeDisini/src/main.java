import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        methodGraph graph = new methodGraph(null);

        // NODE PEMADAM
        graph.addNode("P1", "Pemadam");
        nodeGraph pemadamNode = graph.findNode("P1");
        pemadamNode.laporan = new methodLaporan();

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
        graph.doubleaddEdge("B12", "B14", "Jl. Mawar Satu", 60);
        graph.doubleaddEdge("B12", "B16", "Jl. Mawar Dua", 70);
        
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

        //Data manual untuk coba search dan sorting
        pemadamNode.laporan.enqueue("REP-001", 8, 7, 6, 5, 4, "B3");
        pemadamNode.laporan.enqueue("REP-002", 7, 6, 5, 4, 3, "B7");
        pemadamNode.laporan.enqueue("REP-003", 9, 8, 7, 6, 5, "B1");

        //Disini mulai SCANNER
        Scanner input = new Scanner(System.in);
        
        boolean running = true;
        while (running) {
            graph.UI();
            System.out.print("Pilih menu: ");
            int choice = input.nextInt();
            input.nextLine(); // Clear buffer
            
            switch (choice) {
                case 1:
                    System.out.println("\n=== TAMBAH LAPORAN KEBAKARAN ===");
                    
                    String reportID = "REP-" + String.format("%03d", (int)(Math.random() * 1000));
                    
                    String lokasi = "";
                    boolean validLokasi = false;
                    while (!validLokasi) {
                        pemadamNode.laporan.UIlokasiKebakaran(); 
                        lokasi = input.nextLine();
                        if (graph.findNode(lokasi) != null) {
                            validLokasi = true;
                        } else {
                            System.out.println("Lokasi tidak valid. Silakan coba lagi.");
                        }
                    }

                    pemadamNode.laporan.UIancamanNyawa();
                    int ancamanChoice = input.nextInt();
                    int ancamanPoin = pemadamNode.laporan.getAncamanNyawaPoin(ancamanChoice);

                    pemadamNode.laporan.UIjenisKebakaran();
                    int jenisChoice = input.nextInt();
                    int jenisPoin = pemadamNode.laporan.getJenisKebakaranPoin(jenisChoice);

                    pemadamNode.laporan.UIkecepatanPenyebaran();
                    int kecepatanChoice = input.nextInt();
                    int kecepatanPoin = pemadamNode.laporan.getKecepatanPenyebaranPoin(kecepatanChoice);

                    pemadamNode.laporan.UIwaktuKebakaran();
                    int waktuChoice = input.nextInt();
                    int waktuPoin = pemadamNode.laporan.getWaktuKebakaranPoin(waktuChoice);
                    
                    // Hitung jarak (sementara hardcode, nanti pakai Dijkstra)
                    int lokasiPoin = 10; 

                    pemadamNode.laporan.enqueue(reportID, ancamanPoin, jenisPoin, kecepatanPoin, lokasiPoin, waktuPoin, lokasi);
                    
                    System.out.println("\n Laporan berhasil ditambahkan!");
                    System.out.println("Tekan Enter untuk kembali ke menu utama...");
                    input.nextLine(); // Clear buffer
                    input.nextLine(); // Wait for Enter
                    break;
                    
                case 2:
                    boolean sistemRunning = true;
                    while (sistemRunning) {
                        System.out.println("\n========================================");
                        System.out.println("    SISTEM PEMADAM KEBAKARAN");
                        System.out.println("========================================");
                        System.out.println("1. Lihat Priority Queue & Proses Laporan");
                        System.out.println("2. Riwayat Laporan (Stack)");
                        System.out.println("3. Kembali ke Menu Utama");
                        System.out.println("========================================");
                        System.out.print("Pilih menu: ");
                        int subChoice = input.nextInt();
                        input.nextLine(); // Clear buffer
                        
                        switch (subChoice) {
                            case 1:
                                System.out.println("\n=== PRIORITY QUEUE LAPORAN ===");
                                pemadamNode.laporan.displayQueue();
                                
                                if (pemadamNode.laporan.peek() != null) {
                                    System.out.print("\nProses laporan prioritas tertinggi? (1=Ya, 0=Tidak): ");
                                    int prosesChoice = input.nextInt();
                                    input.nextLine();
                                    
                                    if (prosesChoice == 1) {
                                        // Dequeue laporan tertinggi
                                        FireReport laporan = pemadamNode.laporan.dequeue();
                                        
                                        if (laporan != null) {
                                            System.out.println("\n=== MEMPROSES LAPORAN ===");
                                            System.out.println("ID: " + laporan.getReportID());
                                            System.out.println("Lokasi: " + laporan.getLokasiNode());
                                            System.out.println("Prioritas: " + laporan.getPriorityLevel());
                                            System.out.println("Total Poin: " + laporan.getTotalPoint());
                                            System.out.println("Mobil Dikerahkan: " + laporan.getMobilDikerahkan() + " unit");
                                            System.out.println("\n✓ Laporan sedang ditangani...");
                                            
                                            pemadamNode.laporan.pushRiwayat(laporan);
                                            System.out.println("✓ Laporan dipindahkan ke riwayat!");
                                        }
                                    }
                                }
                                
                                System.out.println("\nTekan Enter untuk kembali...");
                                input.nextLine();
                                break;
                                
                            case 2:
                                boolean riwayatRunning = true;
                                while (riwayatRunning) {
                                    System.out.println("\n========================================");
                                    System.out.println("        RIWAYAT LAPORAN (STACK)");
                                    System.out.println("========================================");
                                    System.out.println("1. Lihat Semua Riwayat");
                                    System.out.println("2. Search by ID");
                                    System.out.println("3. Search by Lokasi");
                                    System.out.println("4. Sorting by ID");
                                    System.out.println("5. Sorting by Lokasi");
                                    System.out.println("6. Sorting by Total Point");
                                    System.out.println("7. Kembali");
                                    System.out.println("========================================");
                                    System.out.print("Pilih menu: ");
                                    int riwayatChoice = input.nextInt();
                                    input.nextLine();
                                    
                                    switch (riwayatChoice) {
                                        case 1:
                                            System.out.println("\n=== SEMUA RIWAYAT LAPORAN ===");
                                            pemadamNode.laporan.displayStack();
                                            System.out.println("\nTekan Enter untuk kembali...");
                                            input.nextLine();
                                            break;
                                            
                                        case 2:
                                            System.out.print("\nMasukkan ID Laporan: ");
                                            String searchID = input.nextLine();
                                            pemadamNode.laporan.searchByID(searchID);
                                            System.out.println("\nTekan Enter untuk kembali...");
                                            input.nextLine();
                                            break;
                                            
                                        case 3:
                                            System.out.print("\nMasukkan Lokasi: ");
                                            String searchLokasi = input.nextLine();
                                            pemadamNode.laporan.searchByLokasi(searchLokasi);
                                            System.out.println("\nTekan Enter untuk kembali...");
                                            input.nextLine();
                                            break;
                                            
                                        case 4:
                                            System.out.println("\n=== SORTING BY ID ===");
                                            pemadamNode.laporan.sortByID();
                                            pemadamNode.laporan.displayStack();
                                            System.out.println("\nTekan Enter untuk kembali...");
                                            input.nextLine();
                                            break;
                                            
                                        case 5:
                                            System.out.println("\n=== SORTING BY LOKASI ===");
                                            pemadamNode.laporan.sortByLokasi();
                                            pemadamNode.laporan.displayStack();
                                            System.out.println("\nTekan Enter untuk kembali...");
                                            input.nextLine();
                                            break;
                                            
                                        case 6:
                                            System.out.println("\n=== SORTING BY TOTAL POINT ===");
                                            pemadamNode.laporan.sortByTotalPoint();
                                            pemadamNode.laporan.displayStack();
                                            System.out.println("\nTekan Enter untuk kembali...");
                                            input.nextLine();
                                            break;
                                            
                                        case 7:
                                            riwayatRunning = false;
                                            break;
                                            
                                        default:
                                            System.out.println("Pilihan tidak valid!");
                                            break;
                                    }
                                }
                                break;
                                
                            case 3:
                                sistemRunning = false;
                                break;
                                
                            default:
                                System.out.println("Pilihan tidak valid!");
                                break;
                        }
                    }
                    break;
                    
                case 0:
                    System.out.println("Keluar dari sistem. Terima kasih!");
                    running = false;
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    System.out.println("Tekan Enter untuk kembali...");
                    input.nextLine();
                    break;
            }
        }
        
        input.close();
    }
}
