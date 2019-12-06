public class Person {
    protected String nama;
    protected String no_hp;

    public Person(String nama, String no_hp){
        this.nama = nama;
        this.no_hp = no_hp;
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }
}
