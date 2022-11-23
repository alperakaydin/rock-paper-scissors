public class AgirTas extends Tas implements IBaseObject {
    public int sicaklik;

    public AgirTas() {
        this.sicaklik = 2;
    }

    public AgirTas(int dayaniklilik, int seviyePuani, int katilik, int sicaklik) {
        super(dayaniklilik, seviyePuani, katilik);
        this.sicaklik = sicaklik;
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
