/*
 * TCSS 305 - Atv
 * 
 */

package model;

import java.util.Map;

/**
 * ATV class implements methods from vehicle class, holds all the 
 * Behaviors for ATV.
 * 
 * @author mohibkohi.
 * @version 1.0.
 *
 */
public class Atv extends AbstractVehicle implements Vehicle {
    
    /**This vehicle's death time.*/
    private static final int DEATH_TIME = 15;
    
    /**
     * Constructor ATV initializes super's instance fields. 
     * 
     * @param theX location of the ATV.
     * @param theY location of the ATV.
     * @param theDir direction of the ATV.
     */
    public Atv(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, "atv", DEATH_TIME);
    }
    
    /**
     * Determines if an ATV can pass with the given Terrain and the
     * current lights. An ATV only will not pass a wall.
     * 
     * @param theTerrain of the ATV.
     * @param theLight the ATV is facing .
     * @return true if ATV can pass false otherwise. 
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean result = false;
        if (theTerrain != Terrain.WALL) {
            result = true;
        }
        return result;
    }

    /**
     * A query that returns the direction in which this vehicle would like 
     * to move, given the specified information. An ATV will choose any 
     * direction, but they will not go on a wall.
     * 
     * @param theNeighbors of the current position of the vehicle.
     * @return the direction the vehicle is to move.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction result = Direction.EAST;
        final Direction direction = super.getDirection();
        Direction random;
        Terrain randDir;
        boolean possibleDir;
        do {
            random = Direction.random();
            randDir = theNeighbors.get(random);
            possibleDir = randDir == Terrain.WALL;
        } while (possibleDir || random == direction.reverse());
        
        result = random;
        return result;
    }
    
    /**
     * ToString prints the name of the current vehicle.
     * @return vehicle name.
     */
    @Override
    public String toString() {
        return super.toString() + " is at x: " + getX() + " y: " 
                        + getY() + " facing " + getDirection();
    }

}
