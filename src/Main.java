import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Login();
    }

    public static void Login(){
        User objUser = new User("","");

        String u="admin", p="admin", user="", pass="";
        int ps;
        boolean bool = true;
        while (bool){
            Scanner scan = new Scanner(System.in);
            System.out.println("==========LOGIN==========");
            System.out.print("Masukkan username : ");
            user = scan.next();
            objUser.dftrUsername.contains(user);
            System.out.print("Masukkan password : ");
            pass = scan.next();
            ps = objUser.dftrUsername.indexOf(user);
            if (objUser.dftrPassword.get(ps).equals(pass) && objUser.dftrUsername.contains(user) == true){
                bool = true;
                System.out.println("Login berhasil");
                Menu();
            }else {
                bool = true;
                System.out.println("Login gagal");
            }

        }

    }

    public static void Menu(){
        Scanner in = new Scanner(System.in);
        int menu;
        System.out.println("Pilih menu : ");
        System.out.println("1. Data Daging");
        System.out.println("2. Data Pemasok");
        System.out.println("3. Transaksi pembelian");
        System.out.println("4. Transaksi penjualan");
        System.out.println("5. Data User");
        System.out.println("6. Keluar");
        System.out.print("Masukkan nomor menu : ");
        menu = in.nextInt();

        switch (menu){
            case 1:
                dataDaging();;
                break;
            case 2:
                // Tambah pemasok
                dataPemasok();
                break;
            case 3:
                Pembelian pembelian = new Pembelian("","","");
                pembelian.inputTransaksi();
                break;
            case 4:
                //transaksi jual
                // pengurangan stok
                Penjualan penjualan = new Penjualan("", "", "");
                penjualan.inputTransaksi();
                break;
            case 5:
                dataUser();
                break;
            case 6:
                //exit
                break;
            default:
                System.out.println("Menu tidak ditemukan");
                break;
        }
    }

    public static void dataUser(){
        Scanner sc = new Scanner(System.in);
        int menu ;
        System.out.println("=============== Data User ==============");
        System.out.println("1. Tampil Data User");
        System.out.println("2. Tambah Data User");
        System.out.println("3. Edit Data User");
        System.out.println("4. Hapus Data User");
        System.out.println("5. Menu Utama");
        System.out.print("Pilih nomor menu: ");
        menu = sc.nextInt();
        User user = new User("", "");
        switch (menu){
            case 1:
                //show data
                user.showData();
                break;
            case 2:
                //Tambah Data User
                user.addUser();
                break;
            case 3:
                //Edit Data User
                user.updateUser();
                break;
            case 4:
                //Hapus Data User
                user.removeUser();
                break;
            case 5:
                //Kembali ke menu utama
                Menu();
                break;
            default:
                System.out.println("Input tidak valid");
                break;


        }
    }

    public static void dataPemasok(){
        Scanner sc = new Scanner(System.in);
        int menu ;
        System.out.println("=============== Data Pemasok ==============");
        System.out.println("1. Tampil Data Pemasok");
        System.out.println("2. Tambah Data Pemasok");
        System.out.println("3. Hapus Data Pemasok");
        System.out.println("4. Menu Utama");
        System.out.print("Pilih nomor menu: ");
        menu = sc.nextInt();
        Pemasok pemasok = new Pemasok("", "");
        switch (menu){
            case 1:
                //show data
                pemasok.showData();
                break;
            case 2:
                //Tambah Data Pemasok
                pemasok.addPemasok();
                break;
            case 3:
                //Hapus Data Pemasok
                pemasok.removePemasok();
                break;
            case 5:
                //Kembali ke menu utama
                Menu();
                break;
            default:
                System.out.println("Input tidak valid");
                break;


        }
    }

    public static void dataDaging(){
        Scanner sc = new Scanner(System.in);
        int menu ;
        System.out.println("=============== Data Daging ==============");
        System.out.println("1. Tampil Data Daging");
        System.out.println("2. Tambah Data Daging");
        System.out.println("3. Edit Data Daging");
        System.out.println("4. Hapus Data Daging");
        System.out.println("5. Cari Data Daging");
        System.out.println("6. Menu Utama");
        System.out.print("Pilih nomor menu: ");
        menu = sc.nextInt();
        Daging daging = new Daging();
        switch (menu){
            case 1:
                //show data
                daging.showDaging();
                break;
            case 2:
                //Tambah Data daging
                daging.insertData();
                break;
            case 3:
                //Edit Data Daging
                daging.updateDaging();
                break;
            case 4:
                //Hapus Data Daging
                daging.removeDaging();
                break;
            case 5:
                //Cari Data Daging
                String key, key1, Nama;
                System.out.print("Masukkan Keyword(kode/kode dan nama) : ");
                Nama = sc.next();
                String str = Nama;
                String[] value = str.split(",");
                int val = value.length;
                if (val>1){
                    key = value[0];
                    key1 = value[1];
                }else {
                    key = value[0];
                    key1 = "";
                }

                if (key1.equals("")){
                    daging.cariData(key);
                }else {
                    daging.cariData(key, key1);
                }
                break;
            case 6:
                //Kembali ke menu utama
                Menu();
                break;
            default:
                System.out.println("Input tidak valid");
                break;
        }
    }


}
