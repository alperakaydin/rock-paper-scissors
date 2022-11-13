public class OyunManager {
    public void hamleYap(IBaseObject OyuncuSecim1, IBaseObject OyuncuSecim2) {
        BaseObject oyuncuSecim1 = (BaseObject) OyuncuSecim1;
        BaseObject oyuncuSecim2 = (BaseObject) OyuncuSecim2;

        int damage1 = OyuncuSecim1.etkiHesapla(OyuncuSecim2);
        int damage2 = OyuncuSecim2.etkiHesapla(OyuncuSecim1);




        if (oyuncuSecim1.dayaniklilik <= damage2){
            System.out.println("Oyuncu2 Kazandı ...");
            // TODO oyuncuSecim1 i Kart Listesinden çıkar

        } else if (oyuncuSecim2.dayaniklilik <= damage1) {
            System.out.println("Oyuncu1 Kazandı ...");
            // TODO oyuncuSecim2 i Kart Listesinden çıkar

        }
        OyuncuSecim1.durumGuncelle(OyuncuSecim2); // Dayanıklılık puanları azaltıldı
        OyuncuSecim2.durumGuncelle(OyuncuSecim1);
        OyuncuSecim1.nesnePuaniGoster();
        OyuncuSecim2.nesnePuaniGoster();

    }
    public void hamleController(Oyuncu oyuncu1, Oyuncu oyuncu2){
        // Oyuncunun her kartını gez
        // Puanı sıfır altına düşen veya 0 olan varsa listeden çıkar
        // Skor puanlarını hesaplattır
        //
        //oyuncu1.list.removeIf(item -> item.nesnePuaniGoster()[0] <= 0);
        //oyuncu2.list.removeIf(item -> item.nesnePuaniGoster()[0] <= 0);

        //System.out.println("Oyuncu1 skor : " + oyuncu1.skorGoster());
        //System.out.println("Oyuncu2 skor : " + oyuncu2.skorGoster());

    }
}
