public class methodLaporan {
    FireReport head;
    FireReport topStack;

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
            case 1: return 40;
            case 2: return 35;
            case 3: return 30;
            case 4: return 25;
            case 5: return 20;
            case 6: return 20;
            case 7: return 10;
            case 8: return 5;
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

    public void enqueue(String reportID, int ancamanPoin, int jenisPoin, int kecepatanPoin, int lokasiPoin, int waktuPoin, String lokasiNode, int jarakMeter) {
        FireReport newReport = new FireReport(reportID, ancamanPoin, jenisPoin, kecepatanPoin, lokasiPoin, waktuPoin, lokasiNode, jarakMeter);

        if (head == null || newReport.totalPoint > head.totalPoint) {
            newReport.next = head;
            head = newReport;
        } else {
            FireReport current = head;
            while (current.next != null && current.next.totalPoint >= newReport.totalPoint) {
                current = current.next;
            }
            newReport.next = current.next;
            current.next = newReport;
        }
    }

    private void enqueueRestore(FireReport report) {
        if (head == null) {
            head = report;
            report.next = null;
        } else {
            FireReport current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = report;
            report.next = null;
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
        System.out.println("Laporan " + removedReport.reportID + " (" +  removedReport.priorityLevel + ") diambil dari queue!");
        return removedReport;
    }

    public void displayQueue() {
        if (head == null) {
            System.out.println("\n=== QUEUE KOSONG ===");
            return;
        }

        System.out.println("\n=== PRIORITY QUEUE (Tertinggi di depan) ===");

        FireReport tempStack = null;

        while (head != null) {
            FireReport current = dequeue();

            System.out.println("     ====== [" + current.reportID + "] ======     ");
            System.out.println("Priority Level       : " + current.priorityLevel);
            System.out.println("Jenis Kebakaran      : " + FireReportHelper.getJenisKebakaranNama(current.jenisKebakaran));
            System.out.println("Ancaman Nyawa        : " + FireReportHelper.getAncamanNyawaNama(current.ancamanNyawa));
            System.out.println("Kecepatan Penyebaran : " + FireReportHelper.getKecepatanPenyebaranNama(current.kecepatanPenyebaran));
            System.out.println("Lokasi Kebakaran     : " + current.lokasiNode + " - Jarak " + current.jarakMeter + " meter");
            System.out.println("Waktu Kebakaran      : " + FireReportHelper.getWaktuKebakaranNama(current.waktuKebakaran));
            System.out.println("Total Point          : " + current.totalPoint);
            System.out.println("----------------------------------------------");

            current.next = tempStack;
            tempStack = current;
        }

        while (tempStack != null) {
            FireReport temp = tempStack;
            tempStack = tempStack.next;
            enqueueRestore(temp);
        }

        System.out.println("============================================\n");
    }


    public FireReport peek() {
        return topStack;
    }

    public FireReport peekQueue() {
        return head;
    }

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

    public void displayStack() {
        if (topStack == null) {
            System.out.println("\n=== RIWAYAT KOSONG ===");
            return;
        }

        System.out.println("\n=== RIWAYAT STACK (Terbaru di atas) ===");

        FireReport tempStack = null;

        while (topStack != null) {
            FireReport current = popRiwayat();

            System.out.println("     ====== [" + current.reportID + "] ======     ");
            System.out.println("Priority Level       : " + current.priorityLevel);
            System.out.println("Jenis Kebakaran      : " + FireReportHelper.getJenisKebakaranNama(current.jenisKebakaran));
            System.out.println("Ancaman Nyawa        : " + FireReportHelper.getAncamanNyawaNama(current.ancamanNyawa));
            System.out.println("Kecepatan Penyebaran : " + FireReportHelper.getKecepatanPenyebaranNama(current.kecepatanPenyebaran));
            System.out.println("Lokasi Kebakaran     : " + current.lokasiNode + " - Jarak " + current.jarakMeter + " meter");
            System.out.println("Waktu Kebakaran      : " + FireReportHelper.getWaktuKebakaranNama(current.waktuKebakaran));
            System.out.println("Total Point          : " + current.totalPoint);
            System.out.println("----------------------------------------------");

            current.next = tempStack;
            tempStack = current;
        }

        while (tempStack != null) {
            FireReport temp = tempStack;
            tempStack = tempStack.next;
            pushRiwayat(temp);
        }

        System.out.println("============================================\n");
    }


   public void searchByID(String id) {
    if (topStack == null) {
        System.out.println("Riwayat kosong!");
        return;
    }

    System.out.println("\n=== HASIL PENCARIAN ID: " + id + " ===");
    boolean found = false;

    FireReport tempStackHead = null; 

    while (topStack != null) {

        FireReport current = popRiwayat(); 

        if (current.reportID.equalsIgnoreCase(id)) {
            System.out.println("✓ DITEMUKAN!");
            System.out.println("  ID: " + current.reportID);
            System.out.println("  Lokasi: " + current.lokasiNode);
            System.out.println("  Jenis Kebakaran: " + FireReportHelper.getJenisKebakaranNama(current.jenisKebakaran));
            System.out.println("  Prioritas: " + current.priorityLevel);
            System.out.println("  Total Point: " + current.totalPoint);
            found = true;
        }

        current.next = tempStackHead;
        tempStackHead = current;

        if (found) {
            break; 
        }
    }

    if (!found) {
        System.out.println("✗ Laporan dengan ID '" + id + "' tidak ditemukan!");
    }

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
                if (current.lokasiNode.equalsIgnoreCase(lokasi)) {
                    System.out.println(count + ". [" + current.reportID + "] " + current.priorityLevel + " - " + current.totalPoint + " poin - Jenis: " + FireReportHelper.getJenisKebakaranNama(current.jenisKebakaran));
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

    public void searchByPriorityLevel(String priority) {
        if (topStack == null) {
            System.out.println("Riwayat kosong!");
            return;
        }

        System.out.println("\n=== HASIL PENCARIAN PRIORITAS: " + priority + " ===");
        boolean found = false;
        int count = 1;

        FireReport tempStackHead = null;

        while (topStack != null) {
            FireReport current = popRiwayat();

            if (current != null) {
                if (current.priorityLevel.equalsIgnoreCase(priority)) {
                    System.out.println(count + ". [" + current.reportID + "] " + 
                                     current.priorityLevel + " - " + 
                                     current.totalPoint + " poin");
                    System.out.println("   Lokasi: " + current.lokasiNode + " | Jenis: " + FireReportHelper.getJenisKebakaranNama(current.jenisKebakaran));
                    found = true;
                    count++;
                }

                current.next = tempStackHead;
                tempStackHead = current;
            }
        }

        if (!found) {
            System.out.println("✗ Tidak ada laporan dengan prioritas '" + priority + "'!");
        }

        while (tempStackHead != null) {
            FireReport nodeToRestore = tempStackHead;
            tempStackHead = tempStackHead.next;

            pushRiwayat(nodeToRestore);
        }
    }

    public void sortByID() {
        if (topStack == null || topStack.next == null) {
            return;
        }

        System.out.println("Sedang mengurutkan Stack berdasarkan ID...");

        FireReport sortedStackHead = null;

        while (topStack != null) {

            FireReport current = popRiwayat();

            while (sortedStackHead != null && 
                   sortedStackHead.reportID.compareTo(current.reportID) > 0) {

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

        System.out.println("✓ Riwayat berhasil diurutkan berdasarkan ID (Strict Stack Method)!");
    }

    public void sortByLokasi() {
        if (topStack == null || topStack.next == null) {
            return;
        }

        System.out.println("Sedang mengurutkan Stack berdasarkan Lokasi...");

        FireReport sortedStackHead = null;

        while (topStack != null) {

            FireReport current = popRiwayat();

            while (sortedStackHead != null && 
                   sortedStackHead.lokasiNode.compareTo(current.lokasiNode) > 0) {

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

        System.out.println("✓ Riwayat berhasil diurutkan berdasarkan Lokasi!");
    }

    public void sortByTotalPoint() {
        if (topStack == null || topStack.next == null) {
            return;
        }

        System.out.println("Sedang mengurutkan Stack berdasarkan Total Point (Highest on Top)...");

        FireReport sortedStackHead = null;

        while (topStack != null) {

            FireReport current = popRiwayat();

            while (sortedStackHead != null && 
                   sortedStackHead.totalPoint < current.totalPoint) {

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

        System.out.println("✓ Riwayat berhasil diurutkan berdasarkan Total Point!");
    }

    public void sortByJenisKebakaran() {
        if (topStack == null || topStack.next == null) {
            return;
        }

        System.out.println("Sedang mengurutkan Stack berdasarkan Jenis Kebakaran (Resiko Tertinggi di Atas)...");

        FireReport sortedStackHead = null;

        while (topStack != null) {

            FireReport current = popRiwayat();


            while (sortedStackHead != null && 
                   sortedStackHead.jenisKebakaran < current.jenisKebakaran) {

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

        System.out.println("✓ Riwayat berhasil diurutkan berdasarkan Jenis Kebakaran!");
    }
}
