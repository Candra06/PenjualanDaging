import java.util.ArrayList;
import java.util.Scanner;

public class Daging {
    ArrayList<String> dftrKode = new ArrayList<String>();
    ArrayList<String> dftrJenis = new ArrayList<String>();
    ArrayList<String> dftrPemasok = new ArrayList<String>();
    ArrayList<String> dftrHBeli = new ArrayList<String>();
    ArrayList<String> dftrHJual = new ArrayList<String>();
    ArrayList<String> dftrStok = new ArrayList<String>();

    protected String kode, jenis, pemasok;
    protected int harga_jual, harga_beli, stok;

    public Daging(){
        dftrKode.add("DG-1");
        dftrJenis.add("Tenderloin");
        dftrPemasok.add("PM01");
        dftrHBeli.add("50000");
        dftrHJual.add("55000");
        dftrStok.add("10");
    }

    public void insertData(){
        Scanner in = new Scanner(System.in);
        boolean dt = false;
        String res;
        System.out.println("========== Input Data Daging ==========");
        while (!dt){
            String lstKode = dftrKode.get(dftrKode.size() - 1);
            String[] getLst = lstKode.split("-");
            int get = Integer.parseInt(getLst[1]) + 1;
            kode = "DG-"+get;
            System.out.println("Kode daging "+kode);
            dftrKode.add(kode);
            System.out.print("Masukkan jenis daging ");
            jenis = in.next();
            dftrJenis.add(jenis);
            System.out.print("Masukkan pemasok daging ");
            pemasok = in.next();
            dftrPemasok.add(pemasok);
            System.out.print("Masukkan harga beli daging ");
            harga_beli = in.nextInt();
            dftrHBeli.add(String.valueOf(harga_beli));
            System.out.print("Masukkan harga jual daging ");
            harga_jual = in.nextInt();
            dftrHJual.add(String.valueOf(harga_jual));
            System.out.print("Masukkan stok daging ");
            stok = in.nextInt();
            dftrStok.add(String.valueOf(stok));
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
            System.out.println("------------------------------");
        }
    }


}
