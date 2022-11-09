public class Tas extends BaseObject {
    public int katilik;

    public Tas() {
    }

    public Tas(int dayaniklilik, int seviyePuani, int katilik) {
        super(dayaniklilik, seviyePuani);
        this.katilik = katilik;
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
