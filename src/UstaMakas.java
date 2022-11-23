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
        int makasEtkisi = 0;
        double a = 0.2;

        if (rakip instanceof AgirTas) {
            makasEtkisi = (int)  (this.keskinlik * this.hiz /
                    ( (1 - a) *  ((AgirTas) rakip).katilik * ((AgirTas) rakip).sicaklik));
            //System.out.println("Obje AgirTas makasEtkisi: " + makasEtkisi);
        } else if (rakip instanceof Tas) {
            makasEtkisi = (int) (this.keskinlik * this.hiz  /
                    ( (1 - a) *  ((Tas) rakip).katilik));
            //System.out.println("Obje Tas makasEtkisi:" + makasEtkisi);
        } else if (rakip instanceof OzelKagit) { // nüfuz ve kalınlık
            makasEtkisi = (int) (this.keskinlik  * this.hiz /
                    (   (a) * ((OzelKagit) rakip).kalinlik) * ((OzelKagit) rakip).nufuz);
            //System.out.println("Obje OzelKagit makasEtkisi:" + makasEtkisi);
        } else if (rakip instanceof Kagit) {
            makasEtkisi = (int) (this.keskinlik * this.hiz  /
                    (   (a) * ((Kagit) rakip).nufuz));
            //System.out.println("Obje Kagit makasEtkisi: " + makasEtkisi);
        } else if (rakip instanceof UstaMakas) {
            makasEtkisi = (int) (this.keskinlik  * this.hiz /
                    (   ((UstaMakas) rakip).hiz) * ((UstaMakas) rakip).keskinlik);
            //System.out.println("Obje UstaMakas makasEtkisi: " + makasEtkisi);
        } else if (rakip instanceof Makas) {
            makasEtkisi = (int) (this.keskinlik  * this.hiz /
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


}
