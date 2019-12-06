import java.util.ArrayList;

public class Pemasok extends Person {

    ArrayList<String> dftrKode = new ArrayList<String>();
    ArrayList<String> dftrNama = new ArrayList<String>();
    ArrayList<String> dftrNo_hp = new ArrayList<String>();
    ArrayList<String> dftrAlamat = new ArrayList<String>();

    public Pemasok(String nama, String no_hp) {

        super(nama, no_hp);
        dftrKode.add("PM-1");
        dftrNama.add("Rizal");
        dftrNo_hp.add("085237689012");
        dftrAlamat.add("Jalan Karimata No.15");
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
