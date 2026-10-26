// UTS PBO | Kadek Evan Mahardika | 2501010090
package utspbo.kantin;

/**
 * Class Pesanan untuk mencatat detail pesanan.
 * Melakukan validasi dan mengurangi stok hanya jika semua data valid.
 */
public class Pesanan {
    
    private String kodePesanan;
    private String namaPemesan;
    private Menu menu;
    private int jumlah;
    
    public Pesanan(String kodePesanan, String namaPemesan, Menu menu, int jumlah) 
            throws StokHabisException {
        
        // Validasi data pesanan
        if (menu == null) {
            throw new IllegalArgumentException("Menu tidak boleh kosong");
        }
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah porsi harus lebih dari 0");
        }
        
        // Cek stok (akan melempar StokHabisException jika tidak cukup)
        menu.kurangiStok(jumlah);
        
        this.kodePesanan = kodePesanan;
        this.namaPemesan = namaPemesan;
        this.menu = menu;
        this.jumlah = jumlah;
    }
    
    /**
     * Mencetak detail lengkap pesanan sesuai format soal.
     */
    public void cetakDetail() {
        double subtotal = menu.getHarga() * jumlah;
        double total = menu.hitungTotal(jumlah);
        double biayaTambahan = total - subtotal;
        
        System.out.println("--- DETAIL PESANAN ---");
        System.out.println("Kode pesanan  : " + kodePesanan);
        System.out.println("Pemesan       : " + namaPemesan);
        System.out.println("Menu          : " + menu.getNamaMenu() + " (" + menu.getKodeMenu() + ") x" + jumlah);
        System.out.println("Harga satuan  : Rp" + menu.getHarga());
        System.out.println("Subtotal      : Rp" + subtotal + " (harga x jumlah)");
        
        if (biayaTambahan > 0) {
            System.out.println("Biaya tambahan: Rp" + biayaTambahan + " (" + menu.getKeteranganBiaya() + ")");
        } else {
            System.out.println("Biaya tambahan: Rp0.0");
        }
        
        System.out.println("Total bayar   : Rp" + total);
        System.out.println("Stok tersisa  : " + menu.getStok());
        System.out.println("----------------------");
    }
}