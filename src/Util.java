import java.util.Random;

public class Util {
    public int randomNumberGenerate(int upper) {
        Random rand = new Random();
        return rand.nextInt(upper);
    }

}
