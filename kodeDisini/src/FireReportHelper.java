public class FireReportHelper {

    public static void hitungTotal(FireReport report) {
        report.totalPoint = report.ancamanNyawa + report.jenisKebakaran + report.kecepatanPenyebaran + report.lokasiKebakaran + report.waktuKebakaran;

        if (report.totalPoint >= 110) {
            report.priorityLevel = "CRITICAL";
            report.mobilDikerahkan = 4;
        } else if (report.totalPoint >= 80) {
            report.priorityLevel = "HIGH";
            report.mobilDikerahkan = 3;
        } else if (report.totalPoint >= 50) {
            report.priorityLevel = "MEDIUM";
            report.mobilDikerahkan = 2;
        } else if (report.totalPoint >= 25) {
            report.priorityLevel = "LOW";
            report.mobilDikerahkan = 1;
        } else {
            report.priorityLevel = "MINIMAL";
            report.mobilDikerahkan = 1;
        }
    }

    public static String getJenisKebakaranNama(int jenisKebakaran) {
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

    public static String getAncamanNyawaNama(int ancamanNyawa) {
        switch(ancamanNyawa) {
            case 40: return "Korban terperangkap";
            case 30: return "Korban terluka";
            case 20: return "Potensi korban";
            case 0: return "Tidak ada korban";
            default: return "Unknown";
        }
    }

    public static String getKecepatanPenyebaranNama(int kecepatanPenyebaran) {
        switch(kecepatanPenyebaran) {
            case 30: return "Api membesar sangat cepat";
            case 20: return "Api membesar cepat";
            case 10: return "Api stabil/sedang";
            case 5: return "Api kecil/terkendali";
            default: return "Unknown";
        }
    }

    public static String getWaktuKebakaranNama(int waktuKebakaran) {
        switch(waktuKebakaran) {
            case 15: return "Malam hari (22:00-05:00)";
            case 12: return "Jam sibuk (07:00-09:00, 17:00-19:00)";
            case 10: return "Jam kerja (09:00-17:00)";
            case 8: return "Siang/sore normal (13:00-16:00)";
            case 5: return "Pagi hari (05:00-07:00)";
            default: return "Unknown";
        }
    }
}
