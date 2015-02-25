import java.util.Random;

/**
 * Created by odrzy_000 on 2/23/2015.
 */
public class ImprovedRandom extends Random{

    public ImprovedRandom(){
        super();
    }

    public ImprovedRandom(long seed){
        super(seed);
    }

    public int rangeInt(int min, int max){
        return this.nextInt(max-min) + min;
    }
}
