public class Kagit extends BaseObject {
    public int getNufuz() {
        return nufuz;
    }

    public void setNufuz(int nufuz) {
        this.nufuz = nufuz;
    }

    public int nufuz;

    public Kagit() {

    }

    public Kagit(int dayaniklilik, int seviyePuani, int nufuz) {
        super(dayaniklilik, seviyePuani);
        this.nufuz = nufuz;
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
