import java.util.ArrayList;

public class Kullanici extends Oyuncu {

    public Kullanici() {
    }

    public Kullanici(int oyuncuID, String oyuncuAdi, int skor, ArrayList<IBaseObject> list) {
        super(oyuncuID, oyuncuAdi, skor, list);
    }

    @Override
    public int skorGoster() {
        this.skor =0;
        for (IBaseObject item :
                list) {
            this.skor = this.skor + item.nesnePuaniGoster()[0];

        }
        return this.skor;
    }

    @Override
    public void nesneSec() {

    }

    @Override
    public void nesneSec(int[] secimList) {
        super.list = new ArrayList<>();

        for (int secim :
                secimList) {
            if (secim == 0) {
                Tas tas = new Tas();
                list.add(tas);
            } else if (secim == 1) {
                Makas makas = new Makas();
                list.add(makas);
            } else if (secim == 2) {
                Kagit kagit = new Kagit();
                list.add(kagit);
            }
        }
    }

}
