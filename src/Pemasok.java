import java.util.ArrayList;
import java.util.Scanner;
public class Pemasok extends Person {

    ArrayList<String> dftrKode = new ArrayList<String>();
    ArrayList<String> dftrNama = new ArrayList<String>();
    ArrayList<String> dftrNo_hp = new ArrayList<String>();
    ArrayList<String> dftrAlamat = new ArrayList<String>();

    protected String Kode;

    public Pemasok(String nama, String no_hp) {
        super(nama, no_hp);
        dftrKode.add("PM-1");
        dftrNama.add("Rizal");
        dftrNo_hp.add("085237689012");
        dftrAlamat.add("Jalan Karimata No.15");
    }

    public void addPemasok(){
        Scanner sc = new Scanner(System.in);
        boolean dt = false;
        String res;
        System.out.println("========== Input Data Pemasok ==========");
        while (!dt){
            String lstKode = dftrKode.get(dftrKode.size() - 1);
            String[] getLst = lstKode.split("-");
            int get = Integer.parseInt(getLst[1]) + 1;
            kode = "PM-"+get;
            System.out.println("Kode User: "+kode);
            dftrKode.add(kode);
            System.out.print("Masukkan Nama : ");
            setNama(sc.nextLine());
            dftrNama.add(getNama());
            System.out.print("Masukkan No HP : ");
            setNo_hp(sc.nextLine());
            dftrNo_hp.add(getNo_hp());
            System.out.println("Masukkan Alamat : ");
            Alamat = sc.nextLine();
            dftrAlamat.add(this.Alamat);
            System.out.print("Apakah ingin input lagi? y/n ");
            res = sc.next();
            if (res.equals("y")){
                dt = false;
            }else {
                dt = true;
                showData();
            }
        }
    }

    public void showData(){
        System.out.println("=============== Data Pemasok ===============");
        for (int i=0; i<dftrKode.size(); i++ ){
            System.out.println("Kode Pemasok : "+dftrKode.get(i));
            System.out.println("Nama Pemasok : "+dftrNama.get(i));
            System.out.println("No HP : "+dftrNo_hp.get(i));
            System.out.println("Alamat : "+dftrAlamat.get(i));
            System.out.println("----------------------------------------");
        }
    }
}
