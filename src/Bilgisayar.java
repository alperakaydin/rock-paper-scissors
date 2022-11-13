import java.util.ArrayList;

public class Bilgisayar extends Oyuncu {


    public Bilgisayar() {
    }

    public Bilgisayar(int oyuncuID, int oyuncuAdi, int skor, ArrayList<IBaseObject> list) {
        super(oyuncuID, oyuncuAdi, skor, list);
        this.list = list;
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
        // TODO Oyuncu sınıfında bulunan nesneSec metotu override edilecektir. Bilgisayar ba ̧sta ran- dom olarak aldı ̆gı nesneler arasından yine random nesne se ̧cerek hamle yapacaktır.


        super.list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int int_random = new Util().randomNumberGenerate(3);
            if (int_random == 0) {
                Tas tas = new Tas();
                list.add(tas);
            } else if (int_random == 1) {
                Makas makas = new Makas();
                list.add(makas);
            } else if (int_random == 2) {
                Kagit kagit = new Kagit();
                list.add(kagit);
            }
        }
    }

    @Override
    public void nesneSec(int[] secimList) {

    }
}
