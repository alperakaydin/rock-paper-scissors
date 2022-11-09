public class Bilgisayar extends Oyuncu{
    public Bilgisayar() {
    }

    public Bilgisayar(int oyuncuID, int oyuncuAdi, int skor) {
        super(oyuncuID, oyuncuAdi, skor);
    }

    @Override
    public void nesneSec() {
        // TODO Oyuncu sınıfında bulunan nesneSec metotu override edilecektir. Bilgisayar ba ̧sta ran- dom olarak aldı ̆gı nesneler arasından yine random nesne se ̧cerek hamle yapacaktır.
    }
}
