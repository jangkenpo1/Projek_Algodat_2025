public class FireReport {
    String reportID;
    String statusPenyelesaian;
    int ancamanNyawa;
    int jenisKebakaran;
    int kecepatanPenyebaran;
    int lokasiNodePoint;
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
        this.lokasiNodePoint = lokasiPoint;
        this.waktuKebakaran = waktu;
        this.lokasiNode = lokasiNode;

        hitungTotal();
    }

    private void hitungTotal() {
        totalPoint = ancamanNyawa + jenisKebakaran + kecepatanPenyebaran 
                     + lokasiNodePoint + waktuKebakaran;

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
    public int getLokasiNodePoint() { return lokasiNodePoint; }
    public int getWaktuKebakaran() { return waktuKebakaran; }
    public int getTotalPoint() { return totalPoint; }
    public String getPriorityLevel() { return priorityLevel; }
    public int getMobilDikerahkan() { return mobilDikerahkan; }
    public String getLokasiNode() { return lokasiNode; }

    @Override
    public String toString() {
        return String.format("[ID: %s] | Level: %s | Skor: %d | Lokasi: %s",
                             reportID, priorityLevel, totalPoint, lokasiNode);
    }
    public String getIdLaporan() { 
    return reportID; 
    }
    public String getStatusPenyelesaian() { 
        return statusPenyelesaian;
    }
}

