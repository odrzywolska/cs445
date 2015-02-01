/**
 * Created by odrzy_000 on 1/31/2015.
 */
public class Bat extends Creature implements Flyer {
    public Bat(String name) {
        super(name);
    }

    @Override
    public void eat(Thing aThing) {
        if (aThing instanceof Creature) {
            super.eat(aThing);
        } else if (aThing.getClass() == Thing.class) {
            System.out.println(this.toString() + " won't eat a " + aThing.toString() + ".");
        }
    }

    @Override
    public void move() {
        this.fly();
    }

    @Override
    public void fly() {
        System.out.println(this.toString() + " is swooping through the dark.");
    }
}
