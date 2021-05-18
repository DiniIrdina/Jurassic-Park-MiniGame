package game.action;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import game.actor.Dinosaur;
import game.item.AllosaurEgg;
import game.item.BrachiosaurEgg;
import game.item.StegosaurEgg;

/**
 * A class that tackles the BreedingAction from the dinosaurs to breed. Once the breeding has been concluded,
 * an Egg will be added to the female dinosaur's inventory.
 */
public class BreedingAction extends Action {
    private Dinosaur target;
    private String stegosaur = "Stegosaur";
    private String brachiosaur = "Brachiosaur";
    private String allosaur = "Allosaur";
    private String pterodactyl = "Pterodactyl";

    /**
     * The constructor for the Breeding Action
     * @param dino the target dinosaur to be breed with
     */
    public BreedingAction(Dinosaur dino){
        this.target = dino;
    }

    /**
     * This method is used for breeding between dinosaurs. It checks if the dinosaurs are of different genders and if they
     * are of the same species. If these conditions are met, the appropriate Egg object will be created and added to the
     * female's inventory.
     * @param actor The actor executing the action.
     * @param map The map the actor is currently on.
     * @return    The menudescription of the action, a string.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (target.getGender() != ((Dinosaur)actor).getGender()){
            if (target.getSpecies().equals(((Dinosaur)actor).getSpecies())){
                if (((Dinosaur)actor).getGender() == 'F' && target.getGender()=='M'){
                    if (target.getSpecies().equals(stegosaur)){
                        actor.addItemToInventory(new StegosaurEgg());
                    }
                    else if (target.getSpecies().equals(brachiosaur)){
                        actor.addItemToInventory(new BrachiosaurEgg());
                    }
                    else if (target.getSpecies().equals(allosaur)){
                        actor.addItemToInventory(new AllosaurEgg());
                    }

                }
                else{
                    if (target.getSpecies().equals(stegosaur)){
                        target.addItemToInventory(new StegosaurEgg());
                    }
                    else if (target.getSpecies().equals(brachiosaur)){
                        target.addItemToInventory(new BrachiosaurEgg());
                    }
                    else if (target.getSpecies().equals(allosaur)){
                        target.addItemToInventory(new AllosaurEgg());
                    }
                }
            }
        }
        return menuDescription(actor);
    }

    /**
     * Returns a String that describes the action executed.
     * @param actor The actor performing the action.
     * @return a String that will be displayed.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor +" has finished mating with " + target;
    }
}
