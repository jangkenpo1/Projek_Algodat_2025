public class FireReport {
    String reportID;
    int ancamanNyawa;
    int jenisKebakaran;
    int kecepatanPenyebaran;
    int waktuKebakaran;
    int lokasiKebakaran;
    int jarakMeter;

    int totalPoint;
    String priorityLevel;
    int mobilDikerahkan;
    String lokasiNode;
    String ruteDilalui;
    FireReport next;

    public FireReport(String reportID, int nyawa, int jenis, int penyebaran, int lokasiPoint, int waktu, String lokasiNode, int jarak, String ruteDilalui) {
        this.reportID = reportID;
        this.ancamanNyawa = nyawa;
        this.jenisKebakaran = jenis;
        this.kecepatanPenyebaran = penyebaran;
        this.lokasiKebakaran = lokasiPoint;
        this.waktuKebakaran = waktu;
        this.lokasiNode = lokasiNode;
        this.jarakMeter = jarak;
        this.ruteDilalui = ruteDilalui;
        FireReportHelper.hitungTotal(this);
    }
}
