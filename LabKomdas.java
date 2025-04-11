// Program 2: CV Labkomdas 
import java.util.Scanner; // Import Scanner untuk membaca input dari pengguna

public class LabKomdas { // Class yang merepresentasikan sistem pemesanan jaket di CV Labkomdas

    // Harga jaket ditentukan sebagai konstanta final karena bersifat tetap dan tidak boleh diubah
    private final int HARGA_A = 100000; // 'private' karena hanya digunakan dalam class ini saja
    private final int HARGA_B = 125000;
    private final int HARGA_C = 175000;

    // Method non-static karena memerlukan objek untuk menggunakan data non-static di atas
    public int hitungHarga(char tipe, int jumlah) {
        int harga = 0; // Variabel untuk menyimpan harga per jaket berdasarkan tipe dan diskon

        // Menentukan harga berdasarkan tipe jaket dan apakah mendapat diskon atau tidak
        if (tipe == 'A') {
            harga = (jumlah > 100) ? 95000 : HARGA_A; // Diskon jika beli lebih dari 100
        } else if (tipe == 'B') {
            harga = (jumlah > 100) ? 120000 : HARGA_B;
        } else if (tipe == 'C') {
            harga = (jumlah > 100) ? 160000 : HARGA_C;
        } else {
            System.out.println("Tipe jaket tidaks valid hmmm"); // Menangani input tipe jaket yang tidak sesuai
        }

        return harga * jumlah; // Mengembalikan total harga sesuai jumlah yang dibeli
    }

    // Method main digunakan untuk interaksi dengan user
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Scanner untuk baca input dari user
        LabKomdas toko = new LabKomdas(); // Membuat objek dari class LabKomdas

        while (true) { // Looping menu supaya user bisa memilih lebih dari satu kali
            // Menampilkan menu pilihan
            System.out.println("\n--- ME N U ---");
            System.out.println("1. Gwe mau pesen jaket");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = input.nextInt(); // Membaca input pilihan dari user

            if (pilihan == 0) break; // Keluar dari loop jika user pilih 0

            switch (pilihan) { // Mengecek pilihan user
                case 1:
                    System.out.print("Masukkan tipe jaket (A/B/C): ");
                    char tipe = input.next().toUpperCase().charAt(0); // Input huruf besar biar konsisten
                    System.out.print("Masukkan jumlah jaket: ");
                    int jumlah = input.nextInt(); // Input jumlah jaket
                    int total = toko.hitungHarga(tipe, jumlah); // Memanggil method untuk menghitung harga
                    System.out.println("Total harga: Rp " + total); // Menampilkan hasil ke layar
                    break;
                default:
                    System.out.println("Pilihan u egk valid."); // Menangani input selain 1 atau 0
            }
        }

        System.out.println("Terima kasiihh telah memesan jaket di CV. Labkomdas^o^!"); // Pesan penutup
    }
}