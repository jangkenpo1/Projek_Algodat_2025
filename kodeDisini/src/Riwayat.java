import java.util.EmptyStackException;
import java.util.Stack;

public class Riwayat {
    // menggunakan Stack untuk menyimpan riwayat laporan kebakaran
    private Stack<FireReport> historyLog; 

    public Riwayat() {
        this.historyLog = new Stack<>();
    }

    public void push(FireReport laporan) {
        historyLog.push(laporan);

        System.out.println("Laporan " + laporan.getReportID() + 
                           " (" + laporan.getStatusPenyelesaian() + ") masuk ke riwayat.");
    }

    public FireReport pop() {
        if (historyLog.isEmpty()) {
            System.out.println("Riwayat laporan kosong/tidak ada.");
            return null;
        }
        FireReport laporanTerakhir = historyLog.pop();
        
        System.out.println("Laporan terakhir " + laporanTerakhir.getReportID() + 
                           " dikeluarkan dari riwayat.");
        return laporanTerakhir;
    }
    
    public FireReport peek() {
        try {
            return historyLog.peek();
        } catch (EmptyStackException e) {
            return null;
        }
    }
    
    public void displayAll() {
        if (historyLog.isEmpty()) {
            System.out.println("\nRiwayat Laporan: KOSONG");
            return;
        }
        System.out.println("\n*** RIWAYAT LAPORAN (LIFO: Terbaru di atas) ***");

        // Iterasi dari akhir Stack ke awal (untuk menampilkan LIFO)
        for (int i = historyLog.size() - 1; i >= 0; i--) {
            System.out.printf("  %d. %s\n", historyLog.size() - i, historyLog.get(i).toString());
        }
        System.out.println("==============================================\n");
    }
}