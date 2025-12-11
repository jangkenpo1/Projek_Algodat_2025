import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        methodGraph graph = new methodGraph(null);

        graph.addNode("P1", "Pemadam");
        nodeGraph pemadamNode = graph.findNode("P1");
        pemadamNode.laporan = new methodLaporan();

        graph.addNode("S1", "Persimpangan Gatot Subroto");
        graph.addNode("S2", "Persimpangan Ahmad Yani");
        graph.addNode("S3", "Persimpangan Sudirman");
        graph.addNode("S4", "Persimpangan Thamrin");
        graph.addNode("S5", "Persimpangan Merdeka");
        graph.addNode("S6", "Persimpangan Diponegoro");
        graph.addNode("S7", "Persimpangan Veteran");

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

        graph.doubleaddEdge("P1", "B16", "Jl. Industri", 5000);
        graph.doubleaddEdge("P1", "S1", "Jl. Merdeka Barat", 5500);

        graph.doubleaddEdge("B1", "S2", "Jl. Soekarno-Hatta", 6500);

        graph.doubleaddEdge("B2", "S2", "Jl. Pahlawan", 7000);
        graph.doubleaddEdge("B2", "B3", "Jl. Kemerdekaan", 8500);
        graph.doubleaddEdge("B2", "B6", "Jl. Imam Bonjol", 5500);

        graph.doubleaddEdge("B3", "S3", "Jl. Proklamasi", 7500);
        graph.doubleaddEdge("B3", "B9", "Jl. Gatot Subroto", 8000);
        graph.doubleaddEdge("B3", "B6", "Jl. Sudirman", 9000);

        graph.doubleaddEdge("B4", "S3", "Jl. Kartini", 9500);
        graph.doubleaddEdge("B4", "B10", "Jl. Letjen Suprapto", 9000);
        graph.doubleaddEdge("B4", "S7", "Jl. Pierre Tendean", 9500);

        graph.doubleaddEdge("B5", "S2", "Jl. Pemuda", 6000);
        graph.doubleaddEdge("B5", "B11", "Jl. Cut Nyak Dien", 7500);

        graph.doubleaddEdge("B6", "B8", "Jl. Teuku Umar", 7000);

        graph.doubleaddEdge("B7", "S2", "Jl. Asia Afrika", 8000);
        graph.doubleaddEdge("B7", "B11", "Jl. Kebon Jeruk", 7000);

        graph.doubleaddEdge("B8", "B9", "Jl. Basuki Rahmat", 6000);
        graph.doubleaddEdge("B8", "B11", "Jl. Naik Haji", 7500);

        graph.doubleaddEdge("B9", "B10", "Jl. Supratman", 7000);

        graph.doubleaddEdge("B10", "S6", "Jl. Wolter Monginsidi", 7500);


        graph.doubleaddEdge("B12", "S1", "Jl. Majapahit", 7000);
        graph.doubleaddEdge("B12", "S4", "Jl. Pemuda Raya", 7500);
        graph.doubleaddEdge("B12", "B14", "Jl. Mawar Satu", 6000);
        graph.doubleaddEdge("B12", "B16", "Jl. Mawar Dua", 7000);

        graph.doubleaddEdge("B13", "S6", "Jl. Pattimura Mundur", 8000);
        graph.doubleaddEdge("B13", "S6", "Jl. Pattimura Maju", 5500);

        graph.doubleaddEdge("B14", "B16", "Jl. Anggrek", 5500);

        graph.doubleaddEdge("B15", "S6", "Jl. Tulip", 7000);

        graph.doubleaddEdge("B16", "S5", "Jl. Flamboyan", 7000);

        graph.doubleaddEdge("B17", "S7", "Jl. Hos Cokroaminoto", 10000);
        graph.doubleaddEdge("B17", "S5", "Jl. Dahlia", 8500);

        graph.doubleaddEdge("S1", "S2", "Jl. Jenderal Sudirman", 6000);

        graph.doubleaddEdge("S4", "S3", "Jl. Melati", 9000);
        graph.doubleaddEdge("S4", "S5", "Jl. Kenanga", 7500);
        graph.doubleaddEdge("S4", "S6", "Jl. Veteran Raya", 8000);

        graph.dijkstraWithRoute("P1", "B3");
        pemadamNode.laporan.enqueue("REP-001", 40, 40, 30, 15, 15, "B3", 27000, graph.getLastRoute());
        
        graph.dijkstraWithRoute("P1", "B7");
        pemadamNode.laporan.enqueue("REP-002", 30, 35, 20, 10, 10, "B7", 19500, graph.getLastRoute());
        
        graph.dijkstraWithRoute("P1", "B1");
        pemadamNode.laporan.enqueue("REP-003", 20, 30, 30, 10, 15, "B1", 18000, graph.getLastRoute());

        Scanner input = new Scanner(System.in);
        int reportCounter = 4;
        boolean running = true;
        while (running) {
            graph.UI();
            System.out.print("Pilih menu: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n=== TAMBAH LAPORAN KEBAKARAN ===");

                    String reportID = "REP-" + String.format("%03d", reportCounter++);

                    String lokasi = "";
                    boolean validLokasi = false;
                    while (!validLokasi) {
                        pemadamNode.laporan.UIlokasiKebakaran(); 
                        System.out.print(">> "); lokasi = input.nextLine();
                        if (graph.findNode(lokasi) != null) {
                            validLokasi = true;
                        } else {
                            System.out.println("Lokasi tidak valid. Silakan coba lagi.");
                        }
                    }

                    pemadamNode.laporan.UIancamanNyawa();
                    int ancamanChoice = input.nextInt();
                    int ancamanPoin = FireReportHelper.getAncamanNyawaPoin(ancamanChoice);

                    pemadamNode.laporan.UIjenisKebakaran();
                    int jenisChoice = input.nextInt();
                    int jenisPoin = FireReportHelper.getJenisKebakaranPoin(jenisChoice);

                    pemadamNode.laporan.UIkecepatanPenyebaran();
                    int kecepatanChoice = input.nextInt();
                    int kecepatanPoin = FireReportHelper.getKecepatanPenyebaranPoin(kecepatanChoice);

                    pemadamNode.laporan.UIwaktuKebakaran();
                    int waktuChoice = input.nextInt();
                    int waktuPoin = FireReportHelper.getWaktuKebakaranPoin(waktuChoice);

                    int jarakMeter = graph.dijkstraWithRoute("P1", lokasi);
                    String ruteDilalui = graph.getLastRoute();
                    int lokasiPoin = graph.lokasiPoin(jarakMeter);

                    System.out.println("Jarak dari P1 ke " + lokasi + ": " + jarakMeter + " meter");
                    
                    if (ruteDilalui != null && !ruteDilalui.isEmpty()) {
                        System.out.println("Rute yang dilalui: " + ruteDilalui);
                    }

                    pemadamNode.laporan.enqueue(reportID, ancamanPoin, jenisPoin, kecepatanPoin, lokasiPoin, waktuPoin, lokasi, jarakMeter, ruteDilalui);

                    System.out.println("\n✓ Laporan berhasil ditambahkan!");
                    System.out.println("Tekan Enter untuk kembali ke menu utama...");
                    input.nextLine();
                    input.nextLine();
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
                        input.nextLine();

                        switch (subChoice) {
                            case 1:
                                System.out.println("\n=== PRIORITY QUEUE LAPORAN ===");
                                pemadamNode.laporan.displayQueue();

                                if (pemadamNode.laporan.peekQueue() != null) {
                                    System.out.print("\nProses laporan prioritas tertinggi? (1=Ya, 0=Tidak): ");
                                    int prosesChoice = input.nextInt();
                                    input.nextLine();

                                    if (prosesChoice == 1) {
                                        FireReport laporan = pemadamNode.laporan.dequeue();

                                        if (laporan != null) {
                                            System.out.println("\n=== MEMPROSES LAPORAN ===");
                                            System.out.println("ID:             :" + laporan.reportID);
                                            System.out.println("Lokasi          : " + laporan.lokasiNode);
                                            System.out.println("Jenis Kebakaran : " + FireReportHelper.getJenisKebakaranNama(laporan.jenisKebakaran));
                                            System.out.println("Prioritas       : " + laporan.priorityLevel);
                                            System.out.println("Total Poin      : " + laporan.totalPoint);
                                            System.out.println("Mobil Dikerahkan: " + laporan.mobilDikerahkan + " unit");
                                            System.out.println("\nLaporan sedang ditangani...");

                                            pemadamNode.laporan.pushRiwayat(laporan);
                                            System.out.println("Laporan dipindahkan ke riwayat!");
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
                                    System.out.println("4. Search by Priority Level");
                                    System.out.println("5. Sorting by ID");
                                    System.out.println("6. Sorting by Lokasi");
                                    System.out.println("7. Sorting by Total Point");
                                    System.out.println("8. Sorting by Jenis Kebakaran");
                                    System.out.println("9. Kembali");
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
                                            System.out.print("\nMasukkan Priority Level (High/Medium/Low/Critical): ");
                                            String searchPriority = input.nextLine();
                                            pemadamNode.laporan.searchByPriorityLevel(searchPriority);
                                            System.out.println("\nTekan Enter untuk kembali...");
                                            input.nextLine();
                                            break;

                                        case 5:
                                            System.out.println("\n=== SORTING BY ID ===");
                                            pemadamNode.laporan.sortByID();
                                            pemadamNode.laporan.displayStack();
                                            System.out.println("\nTekan Enter untuk kembali...");
                                            input.nextLine();
                                            break;

                                        case 6:
                                            System.out.println("\n=== SORTING BY LOKASI ===");
                                            pemadamNode.laporan.sortByLokasi();
                                            pemadamNode.laporan.displayStack();
                                            System.out.println("\nTekan Enter untuk kembali...");
                                            input.nextLine();
                                            break;

                                        case 7:
                                            System.out.println("\n=== SORTING BY TOTAL POINT ===");
                                            pemadamNode.laporan.sortByTotalPoint();
                                            pemadamNode.laporan.displayStack();
                                            System.out.println("\nTekan Enter untuk kembali...");
                                            input.nextLine();
                                            break;

                                        case 8:
                                            System.out.println("\n=== SORTING BY JENIS KEBAKARAN ===");
                                            pemadamNode.laporan.sortByJenisKebakaran();
                                            pemadamNode.laporan.displayStack();
                                            System.out.println("\nTekan Enter untuk kembali...");
                                            input.nextLine();
                                            break;

                                        case 9:
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
