import javax.swing.*;

public class OyunManager {
    public void hamleYap(IBaseObject OyuncuSecim1, IBaseObject OyuncuSecim2, Oyuncu oyuncu1, Oyuncu oyuncu2, JButton[][] buttons) {
        BaseObject oyuncuSecim1 = (BaseObject) OyuncuSecim1;
        BaseObject oyuncuSecim2 = (BaseObject) OyuncuSecim2;

        int damage1 = OyuncuSecim1.etkiHesapla(OyuncuSecim2);
        int damage2 = OyuncuSecim2.etkiHesapla(OyuncuSecim1);

// TODO Bir nesneyi yenen rakip nesnenin seviye puanını 20 artırılacaktır. Seviye puanı 30’un u ̈stu ̈ne ula ̧san nesneler terfi edeceklerdir.


        if (oyuncuSecim1.dayaniklilik <= damage2){
            buttons[0][oyuncu1.list.indexOf(oyuncuSecim1)].setVisible(false);
            System.out.println("oyuncu1 butonu silindi");
            //oyuncu1.list.indexOf(oyuncuSecim1) =
            oyuncuSecim2.seviyePuani+=20;
            System.out.println(OyuncuSecim2.getClass().getName() + " +20 Seviye Puanı Kazandı ...");
            if(oyuncuSecim2.seviyePuani >= 30){


                oyuncu2.list.remove(oyuncuSecim2);
                if (OyuncuSecim2 instanceof Tas){
                    oyuncu2.list.add(new AgirTas());
                    System.out.println("Oyuncu2 AğırTaş nesnesi kazandı");
                } else if (OyuncuSecim2 instanceof Makas) {
                    oyuncu2.list.add(new UstaMakas());
                    System.out.println("Oyuncu2 UstaMakas nesnesi kazandı");
                } else if (OyuncuSecim2 instanceof Kagit) {
                    oyuncu2.list.add(new OzelKagit());
                    System.out.println("Oyuncu2 OzelKağıt nesnesi kazandı");
                }
            }
        } else if (oyuncuSecim2.dayaniklilik <= damage1) {
            buttons[1][oyuncu2.list.indexOf(oyuncuSecim2)].setVisible(false);
            System.out.println("oyuncu2 butonu silindi");
            //oyuncu2.list.remove(oyuncuSecim2);

            oyuncuSecim1.seviyePuani+=20;
            System.out.println(OyuncuSecim1.getClass().getName() + " +20 Seviye Puanı Kazandı ...");
            if(oyuncuSecim1.seviyePuani >= 30){

                oyuncu1.list.remove(oyuncuSecim1);
                if (OyuncuSecim1 instanceof Tas){
                    oyuncu1.list.add(new AgirTas());
                    System.out.println("Oyuncu1 AğırTaş nesnesi kazandı");
                } else if (OyuncuSecim1 instanceof Makas) {
                    oyuncu1.list.add(new UstaMakas());
                    System.out.println("Oyuncu1 UstaMakas nesnesi kazandı");
                } else if (OyuncuSecim2 instanceof Kagit) {
                    oyuncu1.list.add(new OzelKagit());
                    System.out.println("Oyuncu1 OzelKağıt nesnesi kazandı");
                }
            }


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
