public class Makas extends BaseObject implements IBaseObject {

    public int keskinlik;

    public Makas() {
        this.keskinlik = 2;
    }

    public Makas(int dayaniklilik, int seviyePuani, int keskinlik) {
        super(dayaniklilik, seviyePuani);
        this.keskinlik = keskinlik;
    }

    public int getKeskinlik() {
        return keskinlik;
    }

    public void setKeskinlik(int keskinlik) {
        this.keskinlik = keskinlik;
    }

    @Override
    public int etkiHesapla(IBaseObject rakip) {
        int[] rakipPuanlarList = rakip.nesnePuaniGoster();
        //System.out.println(rakipPuanlarList[0]);

        int makasEtkisi = 0;
        double a = 0.2;

        if (rakip instanceof AgirTas) {
            makasEtkisi = (int)  (this.keskinlik /
                    ( (1 - a) *  ((AgirTas) rakip).katilik * ((AgirTas) rakip).sicaklik));
            //System.out.println("Obje AgirTas makasEtkisi: " + makasEtkisi);
        } else if (rakip instanceof Tas) {
            makasEtkisi = (int) (this.keskinlik /
                    ( (1 - a) *  ((Tas) rakip).katilik));
            //System.out.println("Obje Tas makasEtkisi:" + makasEtkisi);
        } else if (rakip instanceof OzelKagit) { // nüfuz ve kalınlık
            makasEtkisi = (int) (this.keskinlik /
                    (   (a) * ((OzelKagit) rakip).kalinlik) * ((OzelKagit) rakip).nufuz);
            //System.out.println("Obje OzelKagit makasEtkisi:" + makasEtkisi);
        } else if (rakip instanceof Kagit) {
            makasEtkisi = (int) (this.keskinlik /
                    (   (a) * ((Kagit) rakip).nufuz));
            //System.out.println("Obje Kagit makasEtkisi: " + makasEtkisi);
        } else if (rakip instanceof UstaMakas) {
            makasEtkisi = (int) (this.keskinlik /
                    (   ((UstaMakas) rakip).hiz) * ((UstaMakas) rakip).keskinlik);
            //System.out.println("Obje UstaMakas makasEtkisi: " + makasEtkisi);
        } else if (rakip instanceof Makas) {
            makasEtkisi = (int) (this.keskinlik /
                    (   ((Makas) rakip).keskinlik));
            //System.out.println("Obje Makas makasEtkisi: " + makasEtkisi);
        }

        return makasEtkisi;
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
        int damage = rakip.etkiHesapla(this);
        this.dayaniklilik -= damage;
        //System.out.println("Damage :" + damage);
    }


}
