public class methodLaporan {
    FireReport head;        // Head untuk Priority Queue
    FireReport topStack;    // Top untuk Stack Riwayat
    
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
            default: return 0;
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
            case 1: return 30;  
            case 2: return 20;  
            case 3: return 10;  
            case 4: return 5;   
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
        if (jarak > 8) return 20;       
        else if (jarak >= 5) return 15; 
        else if (jarak >= 3) return 10; 
        else return 5;                 
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
            case 1: return 15;  
            case 2: return 12; 
            case 3: return 10;  
            case 4: return 8;   
            case 5: return 5;  
            default: return 5;
        }
    }


    // Priority Queue
    public void enqueue(String reportID, int ancamanPoin, int jenisPoin, int kecepatanPoin, int lokasiPoin, int waktuPoin, String lokasiNode) {
        FireReport newReport = new FireReport(reportID, ancamanPoin, jenisPoin, kecepatanPoin, lokasiPoin, waktuPoin, lokasiNode);
        
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
    
    public FireReport peek() {
        return head;
    }
    
    // Push laporan ke stack riwayat
    public void pushRiwayat(FireReport laporan) {
        laporan.next = topStack;
        topStack = laporan;
    }
    
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
        
        System.out.println("\n=== RIWAYAT LAPORAN ===");
        FireReport current = topStack;
        int no = 1;
        while (current != null) {
            System.out.println(no + ". [" + current.getReportID() + "] " +  current.getPriorityLevel() + " - " + current.getTotalPoint() + " poin - Lokasi: " +  current.getLokasiNode());
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
    boolean found = false;

    // Stack Sementara 
    FireReport tempStackHead = null; 

    while (topStack != null) {
        
        FireReport current = popRiwayat(); 
        
        if (current.getReportID().equalsIgnoreCase(id)) {
            System.out.println("✓ DITEMUKAN!");
            System.out.println("  ID: " + current.getReportID());
            System.out.println("  Lokasi: " + current.getLokasiNode());
            System.out.println("  Prioritas: " + current.getPriorityLevel());
            System.out.println("  Total Point: " + current.getTotalPoint());
            found = true;
        }

        // PUSH KE TEMP STACK 
        current.next = tempStackHead;
        tempStackHead = current;

        if (found) {
            break; 
        }
    }

    if (!found) {
        System.out.println("✗ Laporan dengan ID '" + id + "' tidak ditemukan!");
    }

    // RESTORE 
    while (tempStackHead != null) {
        FireReport nodeToRestore = tempStackHead;
        tempStackHead = tempStackHead.next; 
        pushRiwayat(nodeToRestore);
        }
    }

    public void searchByLokasi(String lokasi) {
        if (topStack == null) {
            System.out.println("Riwayat kosong!");
            return;
        }

        System.out.println("\n=== HASIL PENCARIAN LOKASI: " + lokasi + " ===");
        boolean found = false;

        FireReport tempStackHead = null; 
        int count = 1;

        while (topStack != null) {
            FireReport current = popRiwayat();

            if (current != null) {
                if (current.getLokasiNode().equalsIgnoreCase(lokasi)) {
                    System.out.println(count + ". [" + current.getReportID() + "] " + current.getPriorityLevel() + " - " + current.getTotalPoint() + " poin");
                    found = true;
                    count++;
                }

                current.next = tempStackHead;
                tempStackHead = current;
            }
        }

        if (!found) {
            System.out.println("✗ Tidak ada laporan di lokasi '" + lokasi + "'!");
        }

        while (tempStackHead != null) {
            FireReport nodeToRestore = tempStackHead;
            tempStackHead = tempStackHead.next; 
            pushRiwayat(nodeToRestore);
        }
    }
    
    // === SORTING METHODS ===
    
    public void sortByID() {
        if (topStack == null || topStack.next == null) {
            return;
        }
    
        System.out.println("Mengurutkan Stack berdasarkan ID...");
    
        // Stack Sementara buat yang udah terurut 
        FireReport sortedStackHead = null;
    
        while (topStack != null) {
            
            // Ambil satu elemen dari Stack Utama (POP)
            FireReport current = popRiwayat();
        
        
            // untuk Ascending
            while (sortedStackHead != null && sortedStackHead.getReportID().compareTo(current.getReportID()) > 0) {
                
                // Pop dari Sorted Stack
                FireReport temp = sortedStackHead;
                sortedStackHead = sortedStackHead.next; // Geser head turun
                
                // Push BALIK ke Stack Utama
                pushRiwayat(temp);
            }
        
            current.next = sortedStackHead;
            sortedStackHead = current;
        }
    
        // Pindahkan kembali dari Sorted Stack ke Stack Utama
        while (sortedStackHead != null) {
            FireReport temp = sortedStackHead;
            sortedStackHead = sortedStackHead.next;
            
            pushRiwayat(temp);
        }
    
        System.out.println("Riwayat berhasil diurutkan berdasarkan ID !");
    }
        
    public void sortByLokasi() {
        if (topStack == null || topStack.next == null) {
            return;
        }

        System.out.println("Mengurutkan Stack berdasarkan Lokasi...");

        FireReport sortedStackHead = null;

        while (topStack != null) {

            FireReport current = popRiwayat();

            while (sortedStackHead != null && 
                   sortedStackHead.getLokasiNode().compareTo(current.getLokasiNode()) > 0) {
                
                FireReport temp = sortedStackHead;
                sortedStackHead = sortedStackHead.next; 
                
                pushRiwayat(temp);
            }

            current.next = sortedStackHead;
            sortedStackHead = current;
        }

        while (sortedStackHead != null) {
            FireReport temp = sortedStackHead;
            sortedStackHead = sortedStackHead.next;

            pushRiwayat(temp);
        }

        System.out.println("Riwayat berhasil diurutkan berdasarkan Lokasi!");
    }
    
    public void sortByTotalPoint() {
        if (topStack == null || topStack.next == null) {
            return;
        }

        System.out.println("Mengurutkan Stack berdasarkan Total Point (Highest on Top)...");

        FireReport sortedStackHead = null;

        while (topStack != null) {

            FireReport current = popRiwayat();

            while (sortedStackHead != null && 
                   sortedStackHead.getTotalPoint() < current.getTotalPoint()) {
                
                FireReport temp = sortedStackHead;
                sortedStackHead = sortedStackHead.next;
                
                pushRiwayat(temp);
            }
        
            current.next = sortedStackHead;
            sortedStackHead = current;
        }

        while (sortedStackHead != null) {
            FireReport temp = sortedStackHead;
            sortedStackHead = sortedStackHead.next;

            pushRiwayat(temp);
        }

        System.out.println("Riwayat berhasil diurutkan berdasarkan Total Point!");
    }

}