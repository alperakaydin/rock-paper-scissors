public class Kagit extends BaseObject implements IBaseObject {
    public int getNufuz() {
        return nufuz;
    }

    public void setNufuz(int nufuz) {
        this.nufuz = nufuz;
    }

    public int nufuz;

    public Kagit() {
        this.nufuz = 2;

    }

    public Kagit(int dayaniklilik, int seviyePuani, int nufuz) {
        super(dayaniklilik, seviyePuani);
        this.nufuz = nufuz;
    }

    @Override
    public int etkiHesapla(IBaseObject rakip) {
        int[] rakipPuanlarList = rakip.nesnePuaniGoster();
        //System.out.println(rakipPuanlarList[0]);

        int kagitEtkisi = 0;
        double a = 0.2;
        //tas etkisi = katilik{∗sicaklik} (3) (a ∗ keskinlikr {∗direncr } + (1 − a) ∗ nuf uzr {∗kalinlikr }

        if (rakip instanceof AgirTas) {
            kagitEtkisi = (int)(this.nufuz /
                    ( (a) * ((AgirTas) rakip).katilik * ((AgirTas) rakip).sicaklik));
            //System.out.println("Obje AgirTas kagitEtkisi: " + kagitEtkisi);
        } else if (rakip instanceof Tas) {
            kagitEtkisi = (int)(this.nufuz /
                    ( (a) *  ((Tas) rakip).katilik));
            //System.out.println("Obje Tas kagitEtkisi:" + kagitEtkisi);
        } else if (rakip instanceof OzelKagit) { // nüfuz ve kalınlık
            kagitEtkisi = (int) (this.nufuz /
                    (((OzelKagit) rakip).kalinlik) * ((OzelKagit) rakip).nufuz);
            //System.out.println("Obje OzelKagit kagitEtkisi:" + kagitEtkisi);
        } else if (rakip instanceof Kagit) {
            kagitEtkisi = (int) (this.nufuz /
                    (((Kagit) rakip).nufuz));
            //System.out.println("Obje Kagit kagitEtkisi: " + kagitEtkisi);
        } else if (rakip instanceof UstaMakas) {
            kagitEtkisi = (int) (this.nufuz /
                    ((1-a) * ((UstaMakas) rakip).hiz) * ((UstaMakas) rakip).keskinlik);
            //System.out.println("Obje UstaMakas kagitEtkisi: " + kagitEtkisi);
        } else if (rakip instanceof Makas) {
            kagitEtkisi = (int) (this.nufuz /
                    ((1-a) * ((Makas) rakip).keskinlik));
            //System.out.println("Obje Makas kagitEtkisi: " + kagitEtkisi);
        }

        return kagitEtkisi;    }


    @Override
    public int[] nesnePuaniGoster() {
        int[] dizi = new int[5];
        dizi[0] = this.dayaniklilik;
        dizi[1] = this.seviyePuani;
        return dizi;
    }

    @Override
    public void durumGuncelle(IBaseObject rakip) {
        int damage = rakip.etkiHesapla(this);
        this.dayaniklilik -= damage;
        //System.out.println("Damage :" + damage);
    }

}
