// UTS PBO | Kadek Evan Mahardika | 2501010090
package utspbo.kantin;

/**
 * Class Makanan turunan dari Menu.
 * Total = harga × jumlah porsi (tanpa biaya tambahan).
 */
public class Makanan extends Menu {
    
    public Makanan(String kodeMenu, String namaMenu, double harga, int stok) {
        super(kodeMenu, namaMenu, harga, stok);
    }
    
    @Override
    public double hitungTotal(int jumlah) {
        return getHarga() * jumlah;
    }
}