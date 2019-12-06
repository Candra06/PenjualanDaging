import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Daging implements InterfaceDaging {
    ArrayList<String> dftrKode = new ArrayList<String>();
    ArrayList<String> dftrJenis = new ArrayList<String>();
    ArrayList<String> dftrPemasok = new ArrayList<String>();
    ArrayList<String> dftrHBeli = new ArrayList<String>();
    ArrayList<String> dftrHJual = new ArrayList<String>();
    ArrayList<String> dftrStok = new ArrayList<String>();
    ArrayList<String> dftrDateExp = new ArrayList<String>();
    ArrayList<String> dftrStatus = new ArrayList<String>();


    Locale locale = new Locale("fr", "FR");
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
    String date = dateFormat.format(new Date());

    protected String kode, jenis, pemasok;
    protected int harga_jual, harga_beli, stok;

    public Daging(){
        dftrKode.add("DG-1");
        dftrJenis.add("Tenderloin");
        dftrPemasok.add("PM01");
        dftrHBeli.add("50000");
        dftrHJual.add("55000");
        dftrStok.add("10");
        dftrDateExp.add("2019-12-06");
        dftrStatus.add("Fresh");

        dftrKode.add("DG-2");
        dftrJenis.add("Sirloin");
        dftrPemasok.add("PM02");
        dftrHBeli.add("60000");
        dftrHJual.add("70000");
        dftrStok.add("10");
        dftrDateExp.add("2019-12-08");
        dftrStatus.add("Fresh");
    }

    public void insertData(){
        Scanner in = new Scanner(System.in);
        boolean dt = false;
        String res;
        System.out.println("========== Input Data Daging ==========");
        while (!dt){
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String tgl = format.format(date);
            String[] splitDate = tgl.split("/");
            int dd = Integer.parseInt(splitDate[0])+2;
            int MM = Integer.parseInt(splitDate[1])-1;
            int YY = Integer.parseInt(splitDate[2]);
            dftrDateExp.add(get_tgl(YY,MM,dd)); // menambah data pada arraylist dengan memanggil fungsi get tanggal expired
            dftrStatus.add("fresh"); // menambah data pada arraylist
            String lstKode = dftrKode.get(dftrKode.size() - 1);
            String[] getLst = lstKode.split("-");
            int get = Integer.parseInt(getLst[1]) + 1;
            kode = "DG-"+get; // generate kode auto increments
            System.out.println("Kode daging "+kode);
            dftrKode.add(kode); // menambah data pada arraylist
            System.out.print("Masukkan jenis daging ");
            jenis = in.next();
            dftrJenis.add(jenis); // menambah data pada arraylist
            System.out.print("Masukkan pemasok daging : ");
            pemasok = in.next();
            dftrPemasok.add(pemasok); // menambah data pada arraylist
            System.out.print("Masukkan harga beli daging : ");
            harga_beli = in.nextInt();
            dftrHBeli.add(String.valueOf(harga_beli)); // menambah data pada arraylist
            System.out.print("Masukkan harga jual daging : ");
            harga_jual = in.nextInt();
            dftrHJual.add(String.valueOf(harga_jual)); // menambah data pada arraylist
            System.out.print("Masukkan stok daging : ");
            stok = in.nextInt();
            dftrStok.add(String.valueOf(stok)); // menambah data pada arraylist
            System.out.print("Apakah ingin input lagi? y/n ");
            res = in.next();
            if (res.equals("y")){
                dt = false;
            }else {
                dt = true;
                showDaging();
            }
        }
    }

    public void showDaging(){
        System.out.println("========== Data Daging ==========");
        for (int i=0; i<dftrKode.size();i++){
            System.out.println("Kode daging "+dftrKode.get(i));
            System.out.println("Jenis daging "+dftrJenis.get(i));
            System.out.println("Pemasok daging "+dftrPemasok.get(i));
            System.out.println("Harga Beli "+dftrHBeli.get(i));
            System.out.println("Harga Jual "+dftrHJual.get(i));
            System.out.println("Stok daging "+dftrStok.get(i)+"kg");
            System.out.println("Tanggal expired "+dftrDateExp.get(i));
            membusuk();
            System.out.println("Status "+dftrStatus.get(i));
            System.out.println("------------------------------");
        }
    }

    public void removeDaging(){
        Scanner sc = new Scanner(System.in);
        boolean dt = false;
        String res;
        showDaging();
        while(!dt){
            System.out.println("Masukkan Kode Daging yang ingin dihapus : ");
            kode = sc.next();
            boolean data = dftrKode.contains(kode);
            dftrKode.remove(kode);
            System.out.print("Apakah ingin menghapus data lagi? y/n ");
            res = sc.next();
            if (res.equals("y")){
                dt = false;
            }else {
                dt = true;
                showDaging();
            }
        }
    }

    public void updateDaging(){

    }

    public String get_tgl(int th, int bl, int tgl){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = new GregorianCalendar(th,bl,tgl,13,24,56);
        String hasil = sdf.format(calendar.getTime());
        return hasil;
    }

    @Override
    public void membusuk() { // memanggil method dari interface
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String tgl = format.format(date);
        boolean exp = dftrDateExp.contains(tgl); // mencari data dengan tanggal sekarang
        if (exp){
            int gt = dftrDateExp.indexOf(tgl); // mendapatkan index dari data yang telah ada
            dftrStatus.set(gt, "expired"); // mereplace data format(index, value_baru_yang_dirubah)
        }
    }
}
