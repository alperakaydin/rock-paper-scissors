public abstract class BaseObject implements IBaseObject {

    public int dayaniklilik;
    public int seviyePuani;

    public BaseObject() {
        //dayanıklılık de ̆geri tu ̈m nesneler ic ̧in 20, ba ̧slangı ̧c seviye puanı 0’dır.
        this.dayaniklilik = 20;
        this.seviyePuani = 0;
    }

    public BaseObject(int dayaniklilik, int seviyePuani) {
        this.dayaniklilik = dayaniklilik;
        this.seviyePuani = seviyePuani;
    }

    public abstract int etkiHesapla(IBaseObject rakip);

    public abstract int[] nesnePuaniGoster();

    public abstract void durumGuncelle(IBaseObject rakip);

    public int getDayaniklilik() {
        return dayaniklilik;
    }

    public void setDayaniklilik(int dayaniklilik) {
        this.dayaniklilik = dayaniklilik;
    }

    public int getSeviyePuani() {
        return seviyePuani;
    }

    public void setSeviyePuani(int seviyePuani) {
        this.seviyePuani = seviyePuani;
    }


}
