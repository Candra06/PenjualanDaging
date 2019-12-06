public class Transaksi {
    protected String tanggal, petugas;

    public Transaksi(String tanggal, String petugas){
        this.tanggal = tanggal;
        this.petugas = petugas;
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
