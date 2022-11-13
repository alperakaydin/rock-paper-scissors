public class Oyun {

    public Oyun() {


    }

    public static void main(String[] args) {


        Kullanici alper = new Kullanici();
        Bilgisayar pc = new Bilgisayar();
        pc.nesneSec();
        //pc.list.remove(0);
        //System.out.println(pc.skorGoster());

        int[] secimList = {0, 1, 2, 1, 2};
        alper.nesneSec(secimList);

        new GUI(alper,pc);
        //System.out.println(alper.skorGoster());






    }


}