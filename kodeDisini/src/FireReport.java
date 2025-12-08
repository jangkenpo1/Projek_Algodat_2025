public class FireReport {
    String reportID;
    String statusPenyelesaian;
    String Riwayat;

    int ancamanNyawa;
    int jenisKebakaran;
    int kecepatanPenyebaran;
    int lokasiKebakaran;
    int waktuKebakaran;

    int totalPoint;
    String priorityLevel;
    int mobilDikerahkan;
    String lokasiNode;
    FireReport next;

    public FireReport(String reportID, int nyawa, int jenis, int penyebaran, 
                      int lokasiPoint, int waktu, String lokasiNode) {
        this.reportID = reportID;
        this.ancamanNyawa = nyawa;
        this.jenisKebakaran = jenis;
        this.kecepatanPenyebaran = penyebaran;
        this.lokasiKebakaran = lokasiPoint;
        this.waktuKebakaran = waktu;
        this.lokasiNode = lokasiNode;

        hitungTotal();
    }

    public void hitungTotal() {
        totalPoint = ancamanNyawa + jenisKebakaran + kecepatanPenyebaran 
                     + lokasiKebakaran + waktuKebakaran;

        if (totalPoint >= 110) {
            priorityLevel = "CRITICAL";
            mobilDikerahkan = 4;
        } else if (totalPoint >= 80) {
            priorityLevel = "HIGH";
            mobilDikerahkan = 3;
        } else if (totalPoint >= 50) {
            priorityLevel = "MEDIUM";
            mobilDikerahkan = 2;
        } else if (totalPoint >= 25) {
            priorityLevel = "LOW";
            mobilDikerahkan = 1;
        } else {
            priorityLevel = "MINIMAL";
            mobilDikerahkan = 1;
        }
    } 

    public String getReportID() { return reportID; }
    public int getAncamanNyawa() { return ancamanNyawa; }
    public int getJenisKebakaran() { return jenisKebakaran; }
    public int getKecepatanPenyebaran() { return kecepatanPenyebaran; }
    public int getlokasiKebakaran() { return lokasiKebakaran; }
    public int getWaktuKebakaran() { return waktuKebakaran; }
    public int getTotalPoint() { return totalPoint; }
    public String getPriorityLevel() { return priorityLevel; }
    public int getMobilDikerahkan() { return mobilDikerahkan; }
    public String getLokasiNode() { return lokasiNode; }

    public String getIdLaporan() { 
        return reportID; 
    }
    
    public String getStatusPenyelesaian() { 
        return statusPenyelesaian;
    }
    
    public String getJenisKebakaranNama() {
        switch(jenisKebakaran) {
            case 40: return "SPBU/Tangki BBM";
            case 35: return "Rumah Sakit/Sekolah";
            case 30: return "Gedung Bertingkat";
            case 25: return "Pabrik Industri";
            case 20: return "Rumah tinggal/Apartemen";
            case 10: return "Kendaraan";
            case 5: return "Lahan kosong";
            default: return "Unknown";
        }
    }
    
    public String getAncamanNyawaNama() {
        switch(ancamanNyawa) {
            case 40: return "Korban terperangkap";
            case 30: return "Korban terluka";
            case 20: return "Potensi korban";
            case 0: return "Tidak ada korban";
            default: return "Unknown";
        }
    }
    
    public String getKecepatanPenyebaranNama() {
        switch(kecepatanPenyebaran) {
            case 30: return "Api membesar sangat cepat";
            case 20: return "Api membesar cepat";
            case 10: return "Api stabil/sedang";
            case 5: return "Api kecil/terkendali";
            default: return "Unknown";
        }
    }
    
    public String getWaktuKebakaranNama() {
        switch(waktuKebakaran) {
            case 15: return "Malam hari (22:00-05:00)";
            case 12: return "Jam sibuk (07:00-09:00, 17:00-19:00)";
            case 10: return "Jam kerja (09:00-17:00)";
            case 8: return "Siang/sore normal (13:00-16:00)";
            case 5: return "Pagi hari (05:00-07:00)";
            default: return "Unknown";
        }
    }
    
    public String getLokasiKebakaranNama() {
        switch(lokasiKebakaran) {
            case 20: return "Jarak > 8 km (sangat jauh)";
            case 15: return "Jarak 5-8 km (jauh)";
            case 10: return "Jarak 3-5 km (sedang)";
            case 5: return "Jarak < 3 km (dekat)";
            default: return "Unknown";
        }
    }
}

