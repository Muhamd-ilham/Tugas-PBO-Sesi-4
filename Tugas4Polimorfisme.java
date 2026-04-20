import java.util.Scanner;

class Bank {
    public void transferUang(int jumlah, String rekeningTujuan) {
        System.out.println("Transfer Rp" + jumlah + " ke rekening " + rekeningTujuan + " (Sesama Bank) Berhasil.");
    }

    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        System.out.println("Transfer Rp" + jumlah + " ke " + bankTujuan + " [" + rekeningTujuan + "] Berhasil.");
    }

    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        System.out.println("Transfer Rp" + jumlah + " ke " + bankTujuan + " [" + rekeningTujuan + "] Berhasil.");
        System.out.println("Berita: " + berita);
    }

    public void sukuBunga() {
        System.out.println("Suku Bunga standar adalah 3%");
    }
}

class BankBNI extends Bank {
    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga dari BNI adalah: 4%"); 
    }

    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = 6500;
        System.out.println("--- Transaksi BNI ---");
        System.out.println("Transfer Rp" + jumlah + " ke BNI [" + rekeningTujuan + "] Berhasil.");
        System.out.println("Biaya Admin: Rp" + biaya);
        System.out.println("Total Saldo Terpotong: Rp" + (jumlah + biaya));
    }
}

class BankBCA extends Bank {
    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga dari BCA adalah: 4.5%"); 
    }

    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = 2500;
        System.out.println("--- Transaksi BCA ---");
        System.out.println("Transfer Rp" + jumlah + " ke BCA [" + rekeningTujuan + "] Berhasil.");
        System.out.println("Biaya Admin (BI-Fast): Rp" + biaya);
        System.out.println("Total Saldo Terpotong: Rp" + (jumlah + biaya));
    }
}

public class Tugas4Polimorfisme {
    public static void main(String[] args) {
        Bank bankUmum = new Bank();
        BankBNI bni = new BankBNI();
        BankBCA bca = new BankBCA();

        System.out.println("=== DEMO METHOD OVERLOADING ===");
        bankUmum.transferUang(100000, "123456789"); 
        bankUmum.transferUang(250000, "987654321", "MANDIRI");
        bankUmum.transferUang(500000, "555666777", "BRI", "Bayar Kost");
        
        System.out.println("\n=== DEMO METHOD OVERRIDING ===");
        
        bankUmum.sukuBunga(); 
        bni.sukuBunga();     
        bca.sukuBunga();     

        System.out.println("\n=== DEMO BONUS CHALLENGE (BIAYA TRANSFER) ===");
        bni.transferUang(100000, "00112233", "BNI");
        System.out.println();
        bca.transferUang(100000, "44556677", "BCA");
    }
}
