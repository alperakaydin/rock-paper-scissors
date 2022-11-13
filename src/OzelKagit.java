public class OzelKagit extends Kagit implements IBaseObject {
    public int getKalinlik() {
        return kalinlik;
    }

    public void setKalinlik(int kalinlik) {
        this.kalinlik = kalinlik;
    }

    public int kalinlik;

    public OzelKagit() {
        this.kalinlik = 2;
    }

    public OzelKagit(int dayaniklilik, int seviyePuani, int nufuz, int kalinlik) {
        super(dayaniklilik, seviyePuani, nufuz);
        this.kalinlik = kalinlik;
    }

    @Override
    public int etkiHesapla(IBaseObject rakip) {
        return 0;
    }

    @Override
    public int[] nesnePuaniGoster() {
        int[] dizi = new int[5];
        dizi[0] = this.dayaniklilik;
        dizi[1] = this.seviyePuani;
        return dizi;
    }

    @Override
    public void durumGuncelle(IBaseObject rakip) {
        super.durumGuncelle(rakip);
    }
}
