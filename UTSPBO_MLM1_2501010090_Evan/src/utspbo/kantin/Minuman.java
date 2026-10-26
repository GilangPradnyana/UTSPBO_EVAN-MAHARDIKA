// UTS PBO | Kadek Evan Mahardika | 2501010090
package utspbo.kantin;

/**
 * Class Minuman turunan dari Menu.
 * Memiliki biaya kemasan yang dihitung sekali per pesanan.
 */
public class Minuman extends Menu {
    
    private double biayaKemasan;
    
    public Minuman(String kodeMenu, String namaMenu, double harga, int stok, double biayaKemasan) {
        super(kodeMenu, namaMenu, harga, stok);
        
        if (biayaKemasan < 0) {
            throw new IllegalArgumentException("Biaya kemasan tidak boleh negatif");
        }
        this.biayaKemasan = biayaKemasan;
    }
    
    public double getBiayaKemasan() {
        return biayaKemasan;
    }
    
    @Override
    public double hitungTotal(int jumlah) {
        // Kemasan dihitung sekali per pesanan, bukan per porsi
        return (getHarga() * jumlah) + biayaKemasan;
    }
    
    @Override
    public String getKeteranganBiaya() {
        return "kemasan Rp" + biayaKemasan + " sekali per pesanan";
    }
}