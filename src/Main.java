import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Login();
    }

    public static void Login(){
        User objUser = new User("","");
        for (int i=0; i<objUser.dftrUsername.size();i++){

        }
        String u="admin", p="admin", user="", pass="";
        boolean bool = true;
        while (!user.equals(u) && !pass.equals(p)){
            Scanner scan = new Scanner(System.in);
            System.out.println("==========LOGIN==========");
            System.out.print("Masukkan username : ");
            user = scan.next();
            System.out.print("Masukkan password : ");
            pass = scan.next();
        }
        Menu();
    }

    public static void Menu(){
        Scanner in = new Scanner(System.in);
        int menu;
        System.out.println("Pilih menu : ");
        System.out.println("1. Tambah Data Daging");
        System.out.println("2. Tambah Data Pemasok");
        System.out.println("3. Transaksi pembelian");
        System.out.println("4. Transaksi penjualan");
        System.out.println("5. Tambah User");
        System.out.println("6. Keluar");
        System.out.print("Masukkan nomor menu : ");
        menu = in.nextInt();

        switch (menu){
            case 1:
                Daging daging = new Daging();
                daging.insertData();
                break;
            case 2:
                // Tambah pemasok
                Pemasok pemasok = new Pemasok("","");
                pemasok.addPemasok();
                break;
            case 3:
                // Transaksi beli
                break;
            case 4:
                //transaksi jual
                // pengurangan stok
                break;
            case 5:
                User user = new User("","");
                user.addUser();
                break;
            case 6:
                //exit
                break;
            default:
                System.out.println("Menu tidak ditemukan");
                break;
        }
    }


}
