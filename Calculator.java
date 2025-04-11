// PROGRAM 1: OPERASI PERHITUNGAN MATEMATIKA (Penjumlahan, Pengurangan, Perkalian, Pembagian, Pecahan)

// === Penjelasan Program 1: Operasi Matematika ===
// Program ini digunakan untuk menghitung beberapa operasi dasar matematika, yaitu: penjumlahan, pengurangan, perkalian, pembagian, dan penyederhanaan pecahan.
// - Method `penjumlahan` dan `pengurangan` dibuat static, karena tidak butuh objek untuk digunakan.
// - Method `perkalian`, `pembagian`, dan `sederhana` dibuat non-static karena dipanggil lewat objek.
// - Penyederhanaan pecahan dilakukan dengan mencari FPB (Faktor Persekutuan Terbesar).
// - Pengguna diberikan menu untuk memilih operasi yang ingin dilakukan.

import java.util.Scanner; // Import class Scanner untuk membaca input dari user lewat keyboard

public class Calculator { // Class ini isinya kumpulan fungsi buat operasi hitung angka

    static int penjumlahan(int a, int b) { // Static biar bisa langsung dipanggil tanpa bikin objek dulu
        return a + b; // Mengembalikan hasil tambah dari dua angka
    }

    static int pengurangan(int a, int b) { // static juga biar simple panggilnya langsung dari class
        return a - b; // Mengembalikan hasil kurang dari dua angka
    }

    int perkalian(int a, int b) { // Method non-static jadi hrs lewat objek
        return a * b; // Mengembalikan hasil kali
    }

    double pembagian(double a, double b) { // Pakai double karena bisa aja hasilnya pecahan
        if (b == 0) { // Cek biar gaada pembagian sama nol yang bikin error
            System.out.println("Error: gabisa dibagi nol :o"); // pesan error
            return 0; // Nilai deafult
        }
        return a / b; // Hasil bagi kalo semua aman
    }

    int[] sederhana(int pembilang, int penyebut) { // Mengembalikan array krn pecahan ada dua bagian (pembilang oenyebut)
        int fpb = cariFPB(pembilang, penyebut); // Panggil fungsi utk mencari pembagi terbesar
        return new int[]{pembilang / fpb, penyebut / fpb}; // Pecahannya disederhakan pakai FPB
    }

    private int cariFPB(int a, int b) { // bantu buat nyari FPB, gausah dibuka ke luar class makanya private
        while (b != 0) { // Loop terus sampai b jadi 0
            int temp = b; // Simpan dulu nilai b buat nanti dipakai
            b = a % b; // Update b jadi sisa bagi
            a = temp; // a diisi nilai lama b
        }
        return a; // Kalau sdh, itu hasil FPB nya
    }

    public static void main(String[] args) { // Class utama untuk program perhitungan
        Scanner input = new Scanner(System.in); // Scanner agar input user terbaca
        Calculator hitung = new Calculator(); // Membuat objek dari class Calculator agar bisa akses method non-static

        while (true) {  // Perulangan agar menu terus muncul sampai user memilih keluar (pilih 0)
            // Menampilkan menu pilihan ke layar
            System.out.println("\n--- SELAMAT DATANG DI KALKULATOR^^ ---");
            System.out.println("mau hitung apa??");
            System.out.println("1. Penjumlahan");
            System.out.println("2. Pengurangan");
            System.out.println("3. Perkalian");
            System.out.println("4. Pembagian");
            System.out.println("5. Sederhanakan Pecahan");
            System.out.println("0. Keluar sajaa");
            System.out.print("Pilih (0-5): ");
            int pilihan = input.nextInt(); // Membaca pilihan dari user

            if (pilihan == 0) break; // Jika user memilih 0, program berhenti

            // Memproses pilihan berdasarkan input user
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan angka pertama: ");
                    int a1 = input.nextInt();
                    System.out.print("Masukkan angka kedua: ");
                    int b1 = input.nextInt();
                    System.out.println("Hasil Penjumlahan: " + penjumlahan(a1, b1)); // Menampilkan hasil penjumlahan
                    break;

                case 2:
                    System.out.print("Masukkan angka pertama: ");
                    int a2 = input.nextInt();
                    System.out.print("Masukkan angka kedua: ");
                    int b2 = input.nextInt();
                    System.out.println("Hasil Pengurangan: " + pengurangan(a2, b2)); // Menampilkan hasil pengurangan
                    break;

                case 3:
                    System.out.print("Masukkan angka pertama: ");
                    int a3 = input.nextInt();
                    System.out.print("Masukkan angka kedua: ");
                    int b3 = input.nextInt();
                    System.out.println("Hasil Perkalian: " + hitung.perkalian(a3, b3)); // Memanggil method non-static dari objek
                    break;

                case 4:
                    System.out.print("Masukkan angka pertama: ");
                    double a4 = input.nextDouble();
                    System.out.print("Masukkan angka kedua: ");
                    double b4 = input.nextDouble();
                    System.out.println("Hasil Pembagian: " + hitung.pembagian(a4, b4)); // Menampilkan hasil pembagian
                    break;

                case 5:
                    System.out.print("Masukkan pembilang: ");
                    int pembilang = input.nextInt();
                    System.out.print("Masukkan penyebut: ");
                    int penyebut = input.nextInt();
                    int[] hasil = hitung.sederhana(pembilang, penyebut); // Memanggil method untuk menyederhanakan pecahan
                    System.out.println("Hasil Penyederhanaan: " + hasil[0] + "/" + hasil[1]); // Menampilkan pecahan yang disederhanakan
                    break;

                default:
                    System.out.println("Waduhh, pilihan km egk ada nihh. Coba lagi yaw!"); // Jika input tidak sesuai menu yang tersedia
            }
        }

        System.out.println("Terimakashii sudaa menggunakan kalkulator akuw^-^"); // Pesan penutup program
    }
}