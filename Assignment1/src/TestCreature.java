/**
 * Created by odrzy_000 on 1/30/2015.
 */
public class TestCreature {

    public static final int CREATURE_COUNT = 3;
    public static final int THING_COUNT = 10;

    public static void main(String[] args){

        //Part 1
        Thing[] arrayThings = new Thing[THING_COUNT];
        for(int i = 0; i<THING_COUNT-3; i++){
            arrayThings[i] = new Thing("Joe" + i);
        }

        arrayThings[THING_COUNT-3] = new Tiger("Tom");
        arrayThings[THING_COUNT-2] = new Tiger("Thomas");
        arrayThings[THING_COUNT-1] = new Tiger("Tommy");

        System.out.println("Things:\n");
        for(int i = 0; i<THING_COUNT; i++){
            System.out.println(arrayThings[i]);
        }

        //Part 2
        Creature[] arrayCreatures = new Creature[CREATURE_COUNT];
        arrayCreatures[0] = new Bat("Barry");
        arrayCreatures[1] = new Fly("Frank");
        arrayCreatures[2] = new Ant("Adrian");

        System.out.println("\nCreatures:\n");
        for(int i = 0; i<CREATURE_COUNT; i++){
            System.out.println(arrayCreatures[i]);
        }

        //Part 3
        System.out.println("\nCreatures Movement:\n");
        for(int i = 0; i<CREATURE_COUNT; i++){
            System.out.println(arrayCreatures[i]);
            arrayCreatures[i].move();
        }

    }
}
