package game.environment;

import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

import java.util.List;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {
	final double DEFAULT_BUSH_CHANCE = 	0.01;
	final double TWO_BUSH_CHANCE = 0.1;

	public Dirt() {
		super('.');
	}
	public void growBush(Location location){
		double possibility = Math.random();
		int bushes = 0;
		List<Exit> exitList = location.getExits();
		for (int count = 0; count < exitList.size();count++){
			Ground nearbyGround = exitList.get(count).getDestination().getGround();
			if (nearbyGround instanceof Bush){
				bushes++;
			}else if (nearbyGround instanceof Tree){
				return;
			}
		}
		if (bushes >= 2){
			if (possibility < TWO_BUSH_CHANCE){
				createBush(location);
			}
		}else{
			if (possibility < DEFAULT_BUSH_CHANCE){
				createBush(location);
			}
		}
	}


	public void tick(Location location){
		super.tick(location);
		growBush(location);
	}

	public void createBush(Location location){
		Bush bush = new Bush();
		location.setGround(bush);
	}
}
