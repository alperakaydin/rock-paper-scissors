public abstract class Oyuncu {
    public int OyuncuID;
    public int OyuncuAdi;
    public int skor;

    public Oyuncu() {
    }

    public Oyuncu(int oyuncuID, int oyuncuAdi, int skor) {
        this.OyuncuID = oyuncuID;
        this.OyuncuAdi = oyuncuAdi;
        this.skor = skor;
    }
    // TODO nesneListesi  ̈ozelli ̆gi ile oyuncuların elinde bulunan nesneler listede tutulacaktır.
    // TODO SkorGoster fonksiyonu ile oyuncuların skorları g ̈osterilecektir.
    // TODO nesneSec fonksiyonu yazılmalı fakat bu sınıf bilgisayar ve kullanıcı i ̧cin farklı durum- larda  ̧calı ̧saca ̆gı unutulmamalıdır.


    public void skorGoster(){
        // TODO abstract a dönüşebilir !
    }

    public abstract void nesneSec();

    public int getOyuncuID() {
        return OyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        OyuncuID = oyuncuID;
    }

    public int getOyuncuAdi() {
        return OyuncuAdi;
    }

    public void setOyuncuAdi(int oyuncuAdi) {
        OyuncuAdi = oyuncuAdi;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }



}
