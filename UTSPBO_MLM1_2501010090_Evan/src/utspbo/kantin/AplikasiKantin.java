// UTS PBO | Kadek Evan Mahardika | 2501010090
package utspbo.kantin;

import java.util.Scanner;

/**
 * Program utama Sistem Pemesanan Menu Kantin.
 * Menggunakan konsep OOP: inheritance, polymorphism, exception handling.
 */
public class AplikasiKantin {
    
    // Identitas mahasiswa (ganti nama sesuai identitas Anda)
    private static final String NAMA = "Mahasiswa Contoh";
    private static final String NIM  = "2501010090";
    
    // Kode berdasarkan 3 digit terakhir NIM
    private static final String KODE_MK  = "MK-090";
    private static final String KODE_MN  = "MN-090";
    private static final String KODE_SN  = "SN-090";
    private static final String KODE_PSN = "PSN-090";
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // 1. Tampilkan identitas
        System.out.println("UTS PBO | " + NAMA + " | " + NIM);
        
        // 2. Data menu statis
        Menu[] daftarMenu = new Menu[3];
        daftarMenu[0] = new Makanan(KODE_MK, "Nasi Goreng", 15000, 5);
        daftarMenu[1] = new Minuman(KODE_MN, "Es Teh", 5000, 10, 2000);
        daftarMenu[2] = new Snack(KODE_SN, "Keripik", 8000, 4, 1000); // Paket Genap
        
        // 3. Tampilkan daftar menu
        tampilDaftarMenu(daftarMenu);
        
        // Loop untuk menangani input yang salah / stok kurang
        boolean sukses = false;
        
        while (!sukses) {
            try {
                // 4. Pilih menu
                System.out.print("Pilih menu (nomor) : ");
                String inputNomor = input.nextLine().trim();
                
                // Validasi input nomor harus angka
                int nomor;
                try {
                    nomor = Integer.parseInt(inputNomor);
                } catch (NumberFormatException e) {
                    System.out.println(">> Input harus berupa angka bulat, coba lagi.");
                    continue;
                }
                
                if (nomor < 1 || nomor > daftarMenu.length) {
                    System.out.println(">> Nomor menu tidak valid, coba lagi.");
                    continue;
                }
                
                Menu menuDipilih = daftarMenu[nomor - 1];
                
                // 5. Input jumlah porsi
                System.out.print("Jumlah porsi : ");
                String inputJumlah = input.nextLine().trim();
                
                int jumlah;
                try {
                    jumlah = Integer.parseInt(inputJumlah);
                } catch (NumberFormatException e) {
                    System.out.println(">> Input harus berupa angka bulat, coba lagi.");
                    continue;
                }
                
                // 6. Buat pesanan (validasi + kurangi stok di dalam konstruktor)
                Pesanan pesanan = new Pesanan(KODE_PSN, NAMA, menuDipilih, jumlah);
                
                // Jika sampai di sini berarti berhasil
                pesanan.cetakDetail();
                sukses = true;
                
            } catch (StokHabisException e) {
                System.out.println(">> Pesanan ditolak: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(">> Data pesanan tidak valid: " + e.getMessage());
            } finally {
                // Selalu dicetak sesuai ketentuan soal
                System.out.println("[Log] Pengisian pesanan selesai.");
            }
        }
        
        // 8. Penutup program
        System.out.println("Selesai dijalankan oleh " + NAMA + " (" + NIM + ")");
        
        input.close();
    }
    
    /**
     * Menampilkan daftar menu sesuai format soal.
     */
    private static void tampilDaftarMenu(Menu[] daftar) {
        System.out.println("=== DAFTAR MENU KANTIN ===");
        for (int i = 0; i < daftar.length; i++) {
            Menu m = daftar[i];
            System.out.print((i + 1) + ". " + m.getNamaMenu() + " (" + m.getKodeMenu() + ") | Rp" + m.getHarga());
            
            // Tampilkan keterangan biaya tambahan jika ada
            if (m instanceof Minuman) {
                Minuman min = (Minuman) m;
                System.out.print(" + kemasan Rp" + min.getBiayaKemasan() + " sekali per pesanan");
            } else if (m instanceof Snack) {
                Snack sn = (Snack) m;
                System.out.print(" + saus Rp" + sn.getBiayaSaus() + " per porsi");
            }
            
            System.out.println(" | stok " + m.getStok());
        }
    }
}