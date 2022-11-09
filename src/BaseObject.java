public abstract class BaseObject {

    public int dayaniklilik;
    public int seviyePuani;

    public BaseObject() {
    }

    public BaseObject(int dayaniklilik, int seviyePuani) {
        this.dayaniklilik = dayaniklilik;
        this.seviyePuani = seviyePuani;
    }

    public abstract void etkiHesapla();

    public abstract void nesnePuaniGoster();

    public abstract void durumGuncelle();

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
