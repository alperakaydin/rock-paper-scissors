import java.util.Random;

public class Util {
    public int randomNumberGenerate(int upper) {
        Random rand = new Random();
        return rand.nextInt(upper);
    }
    public void waitOneSecond() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("1sn");
    }

}
