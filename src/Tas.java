public class Tas extends BaseObject implements IBaseObject {
    public int katilik;

    public Tas() {
        this.katilik = 2;
    }

    public Tas(int dayaniklilik, int seviyePuani, int katilik) {
        super(dayaniklilik, seviyePuani);
        this.katilik = katilik;
    }

    @Override
    public int etkiHesapla(IBaseObject rakip) {
        int[] rakipPuanlarList = rakip.nesnePuaniGoster();
        //System.out.println(rakipPuanlarList[0]);

        int tasEtkisi = 0;
        double a = 0.2;
        //tas etkisi = katilik{∗sicaklik} (3) (a ∗ keskinlikr {∗direncr } + (1 − a) ∗ nuf uzr {∗kalinlikr }

        if (rakip instanceof AgirTas) {
            tasEtkisi = this.katilik /
                    (((AgirTas) rakip).katilik * ((AgirTas) rakip).sicaklik);
            //System.out.println("Obje AgirTas tasEtkisi: " + tasEtkisi);
        } else if (rakip instanceof Tas) {
            tasEtkisi = this.katilik /
                    (((Tas) rakip).katilik);
            //System.out.println("Obje Tas tasEtkisi:" + tasEtkisi);
        } else if (rakip instanceof OzelKagit) { // nüfuz ve kalınlık
            tasEtkisi = (int) (this.katilik /
                    ((1 - a) * ((OzelKagit) rakip).kalinlik) * ((OzelKagit) rakip).nufuz);
            //System.out.println("Obje OzelKagit tasEtkisi:" + tasEtkisi);
        } else if (rakip instanceof Kagit) {
            tasEtkisi = (int) (this.katilik /
                    ((1 - a) * ((Kagit) rakip).nufuz));
            //System.out.println("Obje Kagit tasEtkisi: " + tasEtkisi);
        } else if (rakip instanceof UstaMakas) {
            tasEtkisi = (int) (this.katilik /
                    (a * ((UstaMakas) rakip).hiz) * ((UstaMakas) rakip).keskinlik);
            //System.out.println("Obje UstaMakas tasEtkisi: " + tasEtkisi);
        } else if (rakip instanceof Makas) {
            tasEtkisi = (int) (this.katilik /
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
        //System.out.println(dizi[0]+ " , "+ dizi[1]);
        return dizi;
    }

    @Override
    public void durumGuncelle(IBaseObject rakip) {
        int damage = rakip.etkiHesapla(this);
        this.dayaniklilik -= damage;
        //System.out.println("Damage :" + damage);

    }
}
