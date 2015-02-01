/**
 * Created by odrzy_000 on 1/31/2015.
 */
public class Fly extends Creature implements Flyer {
    public Fly(String name) {
        super(name);
    }

    @Override
    public void eat(Thing aThing) {
        if(aThing instanceof Creature){
            System.out.println(this.toString() + " won't eat a " + aThing.toString() + ".");
        }
        else {
            super.eat(aThing);
        }
    }

    @Override
    public void move() {
        this.fly();
    }

    @Override
    public void fly() {
        System.out.println(this.toString() + " is buzzing around in flight.");
    }
}
