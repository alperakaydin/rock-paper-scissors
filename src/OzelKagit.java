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
        int kagitEtkisi = 0;
        double a = 0.2;
        //tas etkisi = katilik{∗sicaklik} (3) (a ∗ keskinlikr {∗direncr } + (1 − a) ∗ nuf uzr {∗kalinlikr }

        if (rakip instanceof AgirTas) {
            kagitEtkisi = (int)(this.nufuz * this.kalinlik /
                    ( (a) * ((AgirTas) rakip).katilik * ((AgirTas) rakip).sicaklik));
            //System.out.println("Obje AgirTas kagitEtkisi: " + kagitEtkisi);
        } else if (rakip instanceof Tas) {
            kagitEtkisi = (int)(this.nufuz  * this.kalinlik /
                    ( (a) *  ((Tas) rakip).katilik));
            //System.out.println("Obje Tas kagitEtkisi:" + kagitEtkisi);
        } else if (rakip instanceof OzelKagit) { // nüfuz ve kalınlık
            kagitEtkisi = (int) (this.nufuz  * this.kalinlik /
                    (((OzelKagit) rakip).kalinlik) * ((OzelKagit) rakip).nufuz);
            //System.out.println("Obje OzelKagit kagitEtkisi:" + kagitEtkisi);
        } else if (rakip instanceof Kagit) {
            kagitEtkisi = (int) (this.nufuz  * this.kalinlik /
                    (((Kagit) rakip).nufuz));
            //System.out.println("Obje Kagit kagitEtkisi: " + kagitEtkisi);
        } else if (rakip instanceof UstaMakas) {
            kagitEtkisi = (int) (this.nufuz  * this.kalinlik /
                    ((1-a) * ((UstaMakas) rakip).hiz) * ((UstaMakas) rakip).keskinlik);
            //System.out.println("Obje UstaMakas kagitEtkisi: " + kagitEtkisi);
        } else if (rakip instanceof Makas) {
            kagitEtkisi = (int) (this.nufuz  * this.kalinlik /
                    ((1-a) * ((Makas) rakip).keskinlik));
            //System.out.println("Obje Makas kagitEtkisi: " + kagitEtkisi);
        }

        return kagitEtkisi;

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
