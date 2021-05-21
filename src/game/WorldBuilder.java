package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;
import game.actor.*;
import game.environment.*;

/**
 * The class that generates the map and all other world instances for the Jurassic World game.
 *
 */
public class WorldBuilder {
	public static ArrayList<GameMap> MAPS = new ArrayList<GameMap>();

	public void generateMaps(){
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree(), new VendingMachine(), new Lake());

		//The original map
		List<String> map = Arrays.asList(
		"................................................................................",
		"................................................................................",
		".....#######....................................................................",
		".....#___V_#....................................................................",
		".....#_____#....................................................................",
		".....###.###....................................................................",
		"................................................................................",
		"......................................+++.......................................",
		".......................................++++.....................................",
		"...................................+++++........................................",
		"................~~~~~~~~~~...........++++++.....................................",
		"................~~~~~~~~~~............+++.......................................",
		"................~~~~~~~~~~...........+++........................................",
		"................................................................................",
		"............+++.................................................................",
		".............+++++..............................................................",
		"...............++........................................+++++..................",
		".............+++....................................++++++++....................",
		"............+++.......................................+++.......................",
		"................................................................................",
		".........................................................................++.....",
		"........................................................................++.++...",
		".........................................................................++++...",
		"..........................................................................++....",
		"................................................................................");
		GameMap gameMap = new GameMap(groundFactory, map );
		world.addGameMap(gameMap);
		MAPS.add(gameMap);

		//The second map, extension
		List<String> map2 = Arrays.asList(
		"................................................................................",
		"................................................................................",
		".....#######....................................................................",
		".....#___V_#....................................................................",
		".....#_____#....................................................................",
		".....###.###....................................................................",
		"................................................................................",
		"......................................+++.......................................",
		".......................................++++.....................................",
		"...................................+++++........................................",
		".....................................++++++.....................................",
		"......................................+++.......................................",
		".....................................+++........................................",
		"................................................................................",
		"............+++.................................................................",
		".............+++++..............................................................",
		"...............++................#######.######..........+++++..................",
		".............+++.................#____________#.....++++++++....................",
		"............+++..................#______V_____#.......+++.......................",
		".................................##############.................................",
		".........................................................................++.....",
		"........................................................................++.++...",
		".........................................................................++++...",
		"..........................................................................++....",
		"................................................................................");
		GameMap gameMap2 = new GameMap(groundFactory, map2 );
		world.addGameMap(gameMap2);
		MAPS.add(gameMap2);

		Actor player = new Player("Player", '@', 100);
		world.addPlayer(player, gameMap.at(9, 4));
		
		// Place a pair of stegosaurs in the middle of the map
		gameMap.at(30, 12).addActor(new Stegosaur(18,'F'));
		gameMap.at(32, 12).addActor(new Stegosaur(25,'M'));
		gameMap.at(28,20).addActor(new Brachiosaur(50,'F'));
		gameMap.at(30,15).addActor(new Brachiosaur(50,'M'));
		gameMap.at(25,23).addActor(new Brachiosaur(50,'F'));
		gameMap.at(35,2).addActor(new Brachiosaur(50,'M'));
		gameMap.at(20,10).addActor(new Pterodactyl(30,'M'));
		gameMap.at(18,10).addActor(new Pterodactyl(18,'F'));

		world.run();
	}
}
