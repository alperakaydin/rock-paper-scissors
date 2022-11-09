public class AgirTas extends Tas {
    public int sicaklik;

    public AgirTas() {
    }

    public AgirTas(int dayaniklilik, int seviyePuani, int katilik, int sicaklik) {
        super(dayaniklilik, seviyePuani, katilik);
        this.sicaklik = sicaklik;
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
