// UTS PBO | Kadek Evan Mahardika | 2501010090
package utspbo.kantin;

/**
 * Abstract class Menu sebagai superclass.
 * Menyimpan data dasar menu dan mendefinisikan method abstract hitungTotal.
 */
public abstract class Menu {
    
    private String kodeMenu;
    private String namaMenu;
    private double harga;
    private int stok;
    
    public Menu(String kodeMenu, String namaMenu, double harga, int stok) {
        // Validasi data tidak valid
        if (kodeMenu == null || kodeMenu.trim().isEmpty()) {
            throw new IllegalArgumentException("Kode menu tidak boleh kosong");
        }
        if (namaMenu == null || namaMenu.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama menu tidak boleh kosong");
        }
        if (harga <= 0) {
            throw new IllegalArgumentException("Harga harus lebih dari 0");
        }
        if (stok < 0) {
            throw new IllegalArgumentException("Stok tidak boleh negatif");
        }
        
        this.kodeMenu = kodeMenu;
        this.namaMenu = namaMenu;
        this.harga = harga;
        this.stok = stok;
    }
    
    // Getter
    public String getKodeMenu() {
        return kodeMenu;
    }
    
    public String getNamaMenu() {
        return namaMenu;
    }
    
    public double getHarga() {
        return harga;
    }
    
    public int getStok() {
        return stok;
    }
    
    /**
     * Mengurangi stok. Jika stok tidak cukup, lempar StokHabisException
     * dan stok tidak berubah.
     */
    public void kurangiStok(int jumlah) throws StokHabisException {
        if (jumlah > stok) {
            throw new StokHabisException(
                "Stok " + namaMenu + " tinggal " + stok + 
                ", tidak cukup untuk " + jumlah + " porsi"
            );
        }
        this.stok -= jumlah;
    }
    
    /**
     * Keterangan biaya tambahan. Default "null" untuk menu tanpa biaya tambahan.
     */
    public String getKeteranganBiaya() {
        return "null";
    }
    
    /**
     * Method abstract untuk menghitung total harga sesuai jenis menu.
     */
    public abstract double hitungTotal(int jumlah);
}