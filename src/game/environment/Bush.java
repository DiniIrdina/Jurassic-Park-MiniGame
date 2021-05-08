package game.environment;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import game.item.Fruit;

import java.util.ArrayList;

/**
 * Class creation for the Bush objects found in the game. Bushes will generate fruits based upon
 * a set probability.
 */
public class Bush extends Ground {
    /**
     * Array list to store the fruit objects
     */
    private ArrayList<Fruit> fruits = new ArrayList<>();

    /**
     * Overloading constructor of the Bush class. Bush will be represented by the char 'w'.
     */
    public Bush(){
        super('w');
    }

    /**
     * Removes the fruit from the array list
     */
    public void removeFruit(){
        fruits.remove(fruits.size()-1);
    }

    /**
     * Tick updates the current turn of game for the class object
     * @param location The location of the Ground
     */
    public void tick(Location location){
        super.tick(location);
        double fruitPossibility = 0.1;

        double possibility = Math.random();
        if (possibility<=fruitPossibility && fruits.size() <= 5){
            fruits.add(new Fruit());
        }
    }
}
