public class FireReport {
    String reportID;
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
}
