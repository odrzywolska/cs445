/**
 * Created by odrzy_000 on 1/31/2015.
 */
public class Tiger extends Creature {

    public Tiger(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(this.toString() + " has just pounced.");
    }
}
