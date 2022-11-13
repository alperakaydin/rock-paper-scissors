public class UstaMakas extends Makas implements IBaseObject {
    public int hiz;

    public int getHiz() {
        return hiz;
    }

    public void setHiz(int hiz) {
        this.hiz = hiz;
    }

    public UstaMakas() {
        this.hiz = 2;
    }

    public UstaMakas(int dayaniklilik, int seviyePuani, int keskinlik, int hiz) {
        super(dayaniklilik, seviyePuani, keskinlik);
        this.hiz = hiz;
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


}
