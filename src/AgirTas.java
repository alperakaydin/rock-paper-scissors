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
        int tasEtkisi = 0;
        double a = 0.2;
        //tas etkisi = katilik{∗sicaklik} (3) (a ∗ keskinlikr {∗direncr } + (1 − a) ∗ nuf uzr {∗kalinlikr }

        if (rakip instanceof AgirTas) {
            tasEtkisi = this.katilik *this.sicaklik/
                    (((AgirTas) rakip).katilik * ((AgirTas) rakip).sicaklik);
            //System.out.println("Obje AgirTas tasEtkisi: " + tasEtkisi);
        } else if (rakip instanceof Tas) {
            tasEtkisi = this.katilik *this.sicaklik/
                    (((Tas) rakip).katilik);
            //System.out.println("Obje Tas tasEtkisi:" + tasEtkisi);
        } else if (rakip instanceof OzelKagit) { // nüfuz ve kalınlık
            tasEtkisi = (int) (this.katilik*this.sicaklik /
                    ((1 - a) * ((OzelKagit) rakip).kalinlik) * ((OzelKagit) rakip).nufuz);
            //System.out.println("Obje OzelKagit tasEtkisi:" + tasEtkisi);
        } else if (rakip instanceof Kagit) {
            tasEtkisi = (int) (this.katilik*this.sicaklik /
                    ((1 - a) * ((Kagit) rakip).nufuz));
            //System.out.println("Obje Kagit tasEtkisi: " + tasEtkisi);
        } else if (rakip instanceof UstaMakas) {
            tasEtkisi = (int) (this.katilik*this.sicaklik /
                    (a * ((UstaMakas) rakip).hiz) * ((UstaMakas) rakip).keskinlik);
            //System.out.println("Obje UstaMakas tasEtkisi: " + tasEtkisi);
        } else if (rakip instanceof Makas) {
            tasEtkisi = (int) (this.katilik*this.sicaklik /
                    (a * ((Makas) rakip).keskinlik));
            //System.out.println("Obje Makas tasEtkisi: " + tasEtkisi);
        }

        return tasEtkisi;

    }

    @Override
    public int[] nesnePuaniGoster() {
        int[] dizi = new int[5];
        dizi[0] = this.dayaniklilik;
        dizi[1] = this.seviyePuani;
        return dizi;
    }


}
