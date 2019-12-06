public class Transaksi {
    protected String tanggal, petugas, kode_daging;

    public Transaksi(String tanggal, String petugas, String kode_daging){
        this.tanggal = tanggal;
        this.petugas = petugas;
    }

    public String getKode_daging() {
        return kode_daging;
    }

    public void setKode_daging(String kode_daging) {
        this.kode_daging = kode_daging;
    }

    public String getPetugas() {
        return petugas;
    }

    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
