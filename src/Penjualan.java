import jdk.dynalink.support.ChainedCallSite;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.Scanner;
public class Penjualan extends Transaksi{

    ArrayList<String> listKodeJual = new ArrayList<String>();
    ArrayList<String> listTanggal = new ArrayList<String>();
    ArrayList<String> listKodeDaging = new ArrayList<String>();
    ArrayList<String> listKodePetugas = new ArrayList<String>();
    ArrayList<Integer> listJumlahJual = new ArrayList<Integer>();
    ArrayList<Integer> listTtlHarga = new ArrayList<Integer>();

    private String kode;
    private int jumlah, harga;

    public Penjualan(String tanggal, String petugas, String kode_daging) {
        super(tanggal, petugas, kode_daging);
    }

    public void inputTransaksi() {
        Scanner sc = new Scanner(System.in);
        boolean st = false;
        String kodeDG = "";
        String res;
        while (!st) {
            if (listKodeJual.size() == 0) {
                kode = "TJ-1";
            } else {
                String lstKode = listKodeJual.get(listKodeJual.size() - 1);
                String[] getLast = lstKode.split("-");
                int get = Integer.parseInt(getLast[1]) + 1;
                kode = "TJ-" + get;
            }
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String tgl = format.format(date);

            Daging daging = new Daging();

            System.out.println("Kode Penjualan : " + kode);
            setTanggal(tgl);
            System.out.println("Tanggal penjualan : " + getTanggal());
            System.out.print("Masukkan kode daging : ");
            kodeDG = sc.next();
            setKode_daging(kodeDG);
            System.out.print("Masukkan kode petugas : ");
            setPetugas(sc.next());
            System.out.print("Masukkan jumlah penjualan : ");
            jumlah = sc.nextInt();
            System.out.println(Integer.parseInt(daging.dftrStok.get(daging.dftrKode.indexOf(getKode_daging()))));
            if (Integer.parseInt(daging.dftrStok.get(daging.dftrKode.indexOf(getKode_daging()))) <= jumlah){
                System.out.println("Stok tidak mencukupi!");
                System.out.println("Masukkan data kembali!");
                st = false;
            }else {
                System.out.println("Total harga : " + getHarga(jumlah, getKode_daging()));
                System.out.print("Apakah ingin input lagi? y/n ");
                res = sc.next();
                if (res.equals("y")) {
                    st = false;
                    addData(kode, tgl, getKode_daging(), getPetugas(), jumlah, getHarga(jumlah, getKode_daging()));
                    updateStok(jumlah, getKode_daging());
                } else {
                    st = true;
                    addData(kode, tgl, getKode_daging(), getPetugas(), jumlah, getHarga(jumlah, getKode_daging()));
                    updateStok(jumlah, getKode_daging());
                    show_data();
                }
            }

        }
    }

    public void addData(String kode, String tgl, String daging, String petugas, int jumlah, int ttlHrga) {
        listKodeJual.add(kode);
        listTanggal.add(tgl);
        listKodeDaging.add(daging);
        listKodePetugas.add(petugas);
        listJumlahJual.add(jumlah);
        listTtlHarga.add(ttlHrga);
    }

    public int getHarga(int jumlah, String kode_daging) {
        Daging daging = new Daging();
        daging.dftrKode.contains(kode_daging);
        int id = daging.dftrKode.indexOf(kode_daging);
        int harga = Integer.parseInt(daging.dftrHJual.get(id));
        int hasil = harga * jumlah;
        return hasil;
    }

    public void updateStok(int jumlah, String kode_daging) {
        Daging daging = new Daging();
        daging.dftrKode.contains(kode_daging);
        int id = daging.dftrKode.indexOf(kode_daging);
        int stok = Integer.parseInt(daging.dftrStok.get(id));
        int hasil = stok - jumlah;
        daging.dftrStok.set(id, String.valueOf(hasil));
    }

    public void show_data() {
        System.out.println("=============== List Pembelian ===============");
        for (int i = 0; i < listKodeJual.size(); i++) {
            Daging daging = new Daging();
            daging.dftrKode.contains(listKodeDaging.get(i));
            int id = daging.dftrKode.indexOf(listKodeDaging.get(i));
            int stok = Integer.parseInt(daging.dftrStok.get(id));
            int hasil = stok - jumlah;
            daging.dftrStok.set(id, String.valueOf(hasil));

            System.out.println("Kode Transaksi : " + listKodeJual.get(i));
            System.out.println("Tanggal Transaksi : " + listTanggal.get(i));
            System.out.println("Kode daging : " + listKodeDaging.get(i));
            System.out.println("Kode petugas : " + listKodePetugas.get(i));
            System.out.println("Jumlah : " + listJumlahJual.get(i));
            System.out.println("Total harga : " + listTtlHarga.get(i));
            System.out.println("Stok saat ini : " + daging.dftrStok.set(id, String.valueOf(hasil)));
            System.out.println("------------------------------");
        }
    }

}
