/*
 * TCSS 305 - Truck
 * 
 */
package model;

import java.util.Map;

/**
 * Truck class implements methods from vehicle class, holds all the 
 * Behaviors for Truck.
 * 
 * @author mohibkohi.
 * @version 1.0.
 *
 */
public class Truck extends AbstractVehicle implements Vehicle {
    
    /**This vehicle's death time.*/
    private static final int DEATH_TIME = 0;
    
    /**
     * Constructor Bicycle initializes super's instance fields. 
     * 
     * @param theX location of the Truck.
     * @param theY location of the Truck.
     * @param theDir direction of the Truck.
     */
    public Truck(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, "truck", DEATH_TIME);
    }

    /**
     * A query that returns whether this vehicle can pass through the given 
     * type of terrain. Trucks will pass thru any light, but only on streets.
     * 
     * @param theTerrain vehicle is on.
     * @param theLight vehicle is at. 
     * @return true if the vehicle can pass false otherwise. 
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean result = false;
        if (theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT) {
            result = true;
        }
        return result;
    }

    /**
     * A query that returns the direction in which this vehicle would like 
     * to move, given the specified information. Trucks choose random 
     * directions, but the direction has to be on the street, if no 
     * direction is allowed then truck will turn around. 
     * 
     * @param theNeighbors of the current position of the vehicle.
     * @return the direction the vehicle is to move.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction result = Direction.EAST;
        final Direction direction = super.getDirection();
        final Terrain right = theNeighbors.get(direction.right());
        final Terrain left = theNeighbors.get(direction.left());
        final Terrain straight = theNeighbors.get(direction);

        if (right != Terrain.STREET && right != Terrain.LIGHT
                && left != Terrain.STREET && left != Terrain.LIGHT
                && straight != Terrain.STREET && straight != Terrain.LIGHT) {
            result = direction.reverse();
        } else {
            Direction random;
            Terrain randDir;
            boolean possibleDir;
            do {
                random = Direction.random();
                randDir = theNeighbors.get(random);
                possibleDir = randDir == Terrain.STREET
                        || randDir == Terrain.LIGHT;

            } while (!possibleDir || random == direction.reverse());
            result = random;
        }
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
