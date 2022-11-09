public class Makas extends BaseObject {

    public int keskinlik;

    public Makas() {
    }

    public Makas(int dayaniklilik, int seviyePuani, int keskinlik) {
        super(dayaniklilik, seviyePuani);
        this.keskinlik = keskinlik;
    }

    public int getKeskinlik() {
        return keskinlik;
    }

    public void setKeskinlik(int keskinlik) {
        this.keskinlik = keskinlik;
    }

    @Override
    public void etkiHesapla() {

    }

    @Override
    public void nesnePuaniGoster() {

    }

    @Override
    public void durumGuncelle() {

    }
}
