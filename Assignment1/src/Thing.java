/**
 * Created by odrzy_000 on 1/31/2015.
 */
public class Thing {

    String name;

    public Thing(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        String className = getClass().getSimpleName();
        return this.name + " " + className;
    }
}
