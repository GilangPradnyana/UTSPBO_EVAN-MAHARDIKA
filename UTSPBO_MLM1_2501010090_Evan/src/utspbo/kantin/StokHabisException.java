// UTS PBO | Kadek Evan Mahardika | 2501010090
package utspbo.kantin;

/**
 * Exception khusus ketika stok menu tidak mencukupi.
 * Digunakan untuk menghentikan proses pesanan tanpa mengubah stok.
 */
public class StokHabisException extends Exception {
    
    public StokHabisException(String pesan) {
        super(pesan);
    }
}