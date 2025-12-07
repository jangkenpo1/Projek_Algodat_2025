public class methodLaporan {
    FireReport head;        // Head untuk Priority Queue
    FireReport topStack;    // Top untuk Stack Riwayat

    // === UI MENU UNTUK INPUT LAPORAN ===
    
    public void UIlokasiKebakaran() {
        System.out.println("\n=== Lokasi Kebakaran ===");
        System.out.println("Masukkan nomor bangunan lokasi kebakaran (contoh: B1, S2, P1):");
    }

    public void UIancamanNyawa() {
        System.out.println("\n=== Ancaman Nyawa (0-40 poin) ===");
        System.out.println("1. Korban terperangkap         : +40 poin");
        System.out.println("2. Korban terluka              : +30 poin");  
        System.out.println("3. Potensi korban              : +20 poin");
        System.out.println("4. Tidak ada korban            : +0 poin");
        System.out.print("Pilih (1-4): ");
    }

    public int getAncamanNyawaPoin(int pilihan) {
        switch(pilihan) {
            case 1: return 40;  
            case 2: return 30;  
            case 3: return 20;  
            case 4: return 0;   
            default: return 0;
        }
    }

    public void UIjenisKebakaran() {
        System.out.println("\n=== Jenis Kebakaran (5-40 poin) ===");
        System.out.println("1. SPBU/Tangki BBM             : +40 poin (risiko ledakan)");
        System.out.println("2. Rumah Sakit/Sekolah         : +35 poin");
        System.out.println("3. Gedung Bertingkat           : +30 poin");
        System.out.println("4. Pabrik Industri             : +25 poin");
        System.out.println("5. Rumah tinggal               : +20 poin");
        System.out.println("6. Apartemen                   : +20 poin");
        System.out.println("7. Kendaraan                   : +10 poin");
        System.out.println("8. Lahan kosong                : +5 poin");
        System.out.print("Pilih (1-8): ");
    }

    public int getJenisKebakaranPoin(int pilihan) {
        switch(pilihan) {
            case 1: return 40;  // SPBU/Tangki BBM
            case 2: return 35;  // Rumah Sakit/Sekolah
            case 3: return 30;  // Gedung Bertingkat
            case 4: return 25;  // Pabrik Industri
            case 5: return 20;  // Rumah tinggal
            case 6: return 20;  // Apartemen
            case 7: return 10;  // Kendaraan
            case 8: return 5;   // Lahan kosong
            default: return 5;
        }
    }

    public void UIkecepatanPenyebaran() {
        System.out.println("\n=== Kecepatan Penyebaran (5-30 poin) ===");
        System.out.println("1. Api membesar sangat cepat   : +30 poin");
        System.out.println("2. Api membesar cepat          : +20 poin");
        System.out.println("3. Api stabil/sedang           : +10 poin");
        System.out.println("4. Api kecil/terkendali        : +5 poin");
        System.out.print("Pilih (1-4): ");
    }

    public int getKecepatanPenyebaranPoin(int pilihan) {
        switch(pilihan) {
            case 1: return 30;  // Api membesar sangat cepat
            case 2: return 20;  // Api membesar cepat
            case 3: return 10;  // Api stabil/sedang
            case 4: return 5;   // Api kecil/terkendali
            default: return 5;
        }
    }

    public void UIlokasiNode() {
        System.out.println("\n=== Lokasi Node - Jarak dari Pemadam (5-20 poin) ===");
        System.out.println("Catatan: Poin berdasarkan jarak dari pos pemadam ke lokasi kebakaran");
        System.out.println("Jarak akan dihitung otomatis menggunakan algoritma Dijkstra");
        System.out.println("1. Jarak > 8 km                : +20 poin (sangat jauh)");
        System.out.println("2. Jarak 5-8 km                : +15 poin (jauh)");
        System.out.println("3. Jarak 3-5 km                : +10 poin (sedang)");
        System.out.println("4. Jarak < 3 km                : +5 poin (dekat)");
    }

    public int getLokasiNodePoin(double jarak) {
        if (jarak > 8) return 20;       // Sangat jauh
        else if (jarak >= 5) return 15; // Jauh
        else if (jarak >= 3) return 10; // Sedang
        else return 5;                  // Dekat
    }

    public void UIwaktuKebakaran() {
        System.out.println("\n=== Waktu Kebakaran (5-15 poin) ===");
        System.out.println("1. Malam hari (22:00-05:00)    : +15 poin (orang tidur)");
        System.out.println("2. Jam sibuk (07:00-09:00, 17:00-19:00) : +12 poin (traffic padat)");
        System.out.println("3. Jam kerja (09:00-17:00)     : +10 poin (gedung berisi orang)");
        System.out.println("4. Siang/sore normal (13:00-16:00) : +8 poin");
        System.out.println("5. Pagi hari (05:00-07:00)     : +5 poin");
        System.out.print("Pilih (1-5): ");
    }

    public int getWaktuKebakaranPoin(int pilihan) {
        switch(pilihan) {
            case 1: return 15;  // Malam hari
            case 2: return 12;  // Jam sibuk
            case 3: return 10;  // Jam kerja
            case 4: return 8;   // Siang/sore normal
            case 5: return 5;   // Pagi hari
            default: return 5;
        }
    }


    // Priority Queue: Insert berdasarkan totalPoint (tertinggi di depan)
    public void enqueue(String reportID, int ancamanPoin, int jenisPoin, int kecepatanPoin, int lokasiPoin, int waktuPoin, String lokasiNode) {
        FireReport newReport = new FireReport(reportID, ancamanPoin, jenisPoin, kecepatanPoin, lokasiPoin, waktuPoin, lokasiNode);
        
        // Jika queue kosong atau prioritas lebih tinggi dari head
        if (head == null || newReport.getTotalPoint() > head.getTotalPoint()) {
            newReport.next = head;
            head = newReport;
            System.out.println("Laporan " + reportID + " (" + newReport.getPriorityLevel() + " - " + newReport.getTotalPoint() + " poin) ditambahkan di DEPAN queue!");
        } else {
            FireReport current = head;
            while (current.next != null && current.next.getTotalPoint() >= newReport.getTotalPoint()) {
                current = current.next;
            }
            newReport.next = current.next;
            current.next = newReport;
            System.out.println("Laporan " + reportID + " (" + newReport.getPriorityLevel() +  " - " + newReport.getTotalPoint() + " poin) ditambahkan ke queue!");
        }
    }

    public FireReport dequeue() {
        if (head == null) {
            System.out.println("Queue kosong!");
            return null;
        }
        FireReport removedReport = head;
        head = head.next;
        removedReport.next = null;
        System.out.println("Laporan " + removedReport.getReportID() + " (" +  removedReport.getPriorityLevel() + ") diambil dari queue!");
        return removedReport;
    }

    public void displayQueue() {
        if (head == null) {
            System.out.println("\n=== QUEUE KOSONG ===");
            return;
        }
        
        System.out.println("\n=== PRIORITY QUEUE (Tertinggi di depan) ===");
        FireReport current = head;
        int no = 1;
        while (current != null) {
            System.out.println(no + ". [" + current.getReportID() + "] " + current.getPriorityLevel() + " - " + current.getTotalPoint() + " poin - Lokasi: " + current.getLokasiNode());
            current = current.next;
            no++;
        }
        System.out.println("============================================\n");
    }

    // === STACK METHODS UNTUK RIWAYAT ===
    
    // Method peek untuk queue
    public FireReport peek() {
        return head;
    }
    
    // Push laporan ke stack riwayat
    public void pushRiwayat(FireReport laporan) {
        laporan.next = topStack;
        topStack = laporan;
        System.out.println("✓ Laporan " + laporan.getReportID() + " dipush ke stack riwayat!");
    }
    
    // Pop laporan dari stack
    public FireReport popRiwayat() {
        if (topStack == null) {
            System.out.println("Stack riwayat kosong!");
            return null;
        }
        FireReport popped = topStack;
        topStack = topStack.next;
        popped.next = null;
        return popped;
    }
    
    // Display semua riwayat dalam stack
    public void displayStack() {
        if (topStack == null) {
            System.out.println("\n=== RIWAYAT KOSONG ===");
            return;
        }
        
        System.out.println("\n=== RIWAYAT LAPORAN (LIFO - Terbaru di atas) ===");
        FireReport current = topStack;
        int no = 1;
        while (current != null) {
            System.out.println(no + ". [" + current.getReportID() + "] " + 
                             current.getPriorityLevel() + " - " + 
                             current.getTotalPoint() + " poin - Lokasi: " + 
                             current.getLokasiNode());
            current = current.next;
            no++;
        }
        System.out.println("================================================\n");
    }
    
    // === SEARCH METHODS ===
    
    public void searchByID(String id) {
        if (topStack == null) {
            System.out.println("Riwayat kosong!");
            return;
        }
        
        System.out.println("\n=== HASIL PENCARIAN ID: " + id + " ===");
        FireReport current = topStack;
        boolean found = false;
        
        while (current != null) {
            if (current.getReportID().equalsIgnoreCase(id)) {
                System.out.println("✓ DITEMUKAN!");
                System.out.println("  ID: " + current.getReportID());
                System.out.println("  Lokasi: " + current.getLokasiNode());
                System.out.println("  Prioritas: " + current.getPriorityLevel());
                System.out.println("  Total Point: " + current.getTotalPoint());
                found = true;
                break;
            }
            current = current.next;
        }
        
        if (!found) {
            System.out.println("✗ Laporan dengan ID '" + id + "' tidak ditemukan!");
        }
    }
    
    public void searchByLokasi(String lokasi) {
        if (topStack == null) {
            System.out.println("Riwayat kosong!");
            return;
        }
        
        System.out.println("\n=== HASIL PENCARIAN LOKASI: " + lokasi + " ===");
        FireReport current = topStack;
        boolean found = false;
        int count = 1;
        
        while (current != null) {
            if (current.getLokasiNode().equalsIgnoreCase(lokasi)) {
                System.out.println(count + ". [" + current.getReportID() + "] " + 
                                 current.getPriorityLevel() + " - " + 
                                 current.getTotalPoint() + " poin");
                found = true;
                count++;
            }
            current = current.next;
        }
        
        if (!found) {
            System.out.println("✗ Tidak ada laporan di lokasi '" + lokasi + "'!");
        }
    }
    
    // === SORTING METHODS ===
    
    public void sortByID() {
        if (topStack == null || topStack.next == null) return;
        
        // Bubble sort untuk stack
        boolean swapped;
        do {
            swapped = false;
            FireReport current = topStack;
            FireReport prev = null;
            FireReport next = topStack.next;
            
            while (next != null) {
                if (current.getReportID().compareTo(next.getReportID()) > 0) {
                    swapped = true;
                    
                    if (prev != null) {
                        FireReport temp = next.next;
                        prev.next = next;
                        next.next = current;
                        current.next = temp;
                    } else {
                        FireReport temp = next.next;
                        topStack = next;
                        next.next = current;
                        current.next = temp;
                    }
                    
                    prev = next;
                    next = current.next;
                } else {
                    prev = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (swapped);
        
        System.out.println("✓ Riwayat berhasil diurutkan berdasarkan ID!");
    }
    
    public void sortByLokasi() {
        if (topStack == null || topStack.next == null) return;
        
        boolean swapped;
        do {
            swapped = false;
            FireReport current = topStack;
            FireReport prev = null;
            FireReport next = topStack.next;
            
            while (next != null) {
                if (current.getLokasiNode().compareTo(next.getLokasiNode()) > 0) {
                    swapped = true;
                    
                    if (prev != null) {
                        FireReport temp = next.next;
                        prev.next = next;
                        next.next = current;
                        current.next = temp;
                    } else {
                        FireReport temp = next.next;
                        topStack = next;
                        next.next = current;
                        current.next = temp;
                    }
                    
                    prev = next;
                    next = current.next;
                } else {
                    prev = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (swapped);
        
        System.out.println("✓ Riwayat berhasil diurutkan berdasarkan Lokasi!");
    }
    
    public void sortByTotalPoint() {
        if (topStack == null || topStack.next == null) return;
        
        boolean swapped;
        do {
            swapped = false;
            FireReport current = topStack;
            FireReport prev = null;
            FireReport next = topStack.next;
            
            while (next != null) {
                if (current.getTotalPoint() < next.getTotalPoint()) {
                    swapped = true;
                    
                    if (prev != null) {
                        FireReport temp = next.next;
                        prev.next = next;
                        next.next = current;
                        current.next = temp;
                    } else {
                        FireReport temp = next.next;
                        topStack = next;
                        next.next = current;
                        current.next = temp;
                    }
                    
                    prev = next;
                    next = current.next;
                } else {
                    prev = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (swapped);
        
        System.out.println("✓ Riwayat berhasil diurutkan berdasarkan Total Point (tertinggi ke terendah)!");
    }

}