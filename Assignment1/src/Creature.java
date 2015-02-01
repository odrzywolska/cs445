/**
 * Created by odrzy_000 on 1/31/2015.
 */

public abstract class Creature extends Thing{

    Thing lastAte;

    public Creature(String name){
        super(name);
    }

    public void eat(Thing aThing){
        this.lastAte = aThing;
        System.out.println(this.toString() + " has eaten a " + aThing.toString() + ".");
    }

    public abstract void move();

    public void whatDidYouEat(){
        if(this.lastAte == null){
            System.out.println(this.toString() + " has had nothing to eat!");
        }
        else {
            System.out.println(this.toString() + " has eaten a " + lastAte.toString() + "!");
        }
    }

}
