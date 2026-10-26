// UTS PBO | Kadek Evan Mahardika | 2501010090
package utspbo.kantin;

/**
 * Class Snack turunan dari Menu (Paket NIM Genap).
 * Memiliki biaya saus yang dihitung per porsi.
 * Total = (harga + biaya saus) × jumlah porsi
 */
public class Snack extends Menu {
    
    private double biayaSaus;
    
    public Snack(String kodeMenu, String namaMenu, double harga, int stok, double biayaSaus) {
        super(kodeMenu, namaMenu, harga, stok);
        
        if (biayaSaus < 0) {
            throw new IllegalArgumentException("Biaya saus tidak boleh negatif");
        }
        this.biayaSaus = biayaSaus;
    }
    
    public double getBiayaSaus() {
        return biayaSaus;
    }
    
    @Override
    public double hitungTotal(int jumlah) {
        // Saus dihitung per porsi
        return (getHarga() + biayaSaus) * jumlah;
    }
    
    @Override
    public String getKeteranganBiaya() {
        return "saus Rp" + biayaSaus + " per porsi";
    }
}