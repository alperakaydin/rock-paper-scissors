public class UstaMakas extends Makas {
    public int hiz;

    public int getHiz() {
        return hiz;
    }

    public void setHiz(int hiz) {
        this.hiz = hiz;
    }

    public UstaMakas() {}

    public UstaMakas(int dayaniklilik, int seviyePuani, int keskinlik, int hiz) {
        super(dayaniklilik, seviyePuani, keskinlik);
        this.hiz = hiz;
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
