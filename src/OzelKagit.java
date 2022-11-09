public class OzelKagit extends Kagit {
    public int getKalinlik() {
        return kalinlik;
    }

    public void setKalinlik(int kalinlik) {
        this.kalinlik = kalinlik;
    }

    public int kalinlik;

    public OzelKagit() {
    }

    public OzelKagit(int dayaniklilik, int seviyePuani, int nufuz, int kalinlik) {
        super(dayaniklilik, seviyePuani, nufuz);
        this.kalinlik = kalinlik;
    }

    @Override
    public void etkiHesapla() {
        super.etkiHesapla();
    }

    @Override
    public void nesnePuaniGoster() {
        super.nesnePuaniGoster();
    }

    @Override
    public void durumGuncelle() {
        super.durumGuncelle();
    }
}
