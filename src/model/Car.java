/*
 * TCSS 305 - Car
 */
package model;

import java.util.Map;

/**
 * Vehicle class Car.
 * @author mohibkohi
 * @version 1.0
 */
public class Car extends AbstractVehicle implements Vehicle {
    
    /**This vehicle's death time.*/
    private static final int DEATH_TIME = 5;
    
    /**
     * Constructor car initializes the super fields and passes to the super
     * what kind of vehicle this is. Cars will only drive on streets and thru
     * lights, cars will only stop for red lights. 
     * 
     * @param theX position of the vehicle. 
     * @param theY position of the vehicle. 
     * @param theDir of the vehicle. 
     */
    public Car(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, "car" , DEATH_TIME);       
    }

    /**
     * A query that returns whether this vehicle can pass through the given 
     * type of terrain, when the street lights are in the given state. A car
     * will only choose a direction to straight, straight or right, 
     * if any not possible taxi will turn around.
     * 
     * @param theTerrain vehicle is on.
     * @param theLight vehicle is at. 
     * @return true if the vehicle can pass false otherwise. 
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean result = true;
        if (theTerrain == Terrain.LIGHT) {
            if (theLight == Light.RED) {
                result = false;
            }
        }
        return result;
    }

    /**
     * A query that returns the direction in which this vehicle would like 
     * to move, given the specified information.
     * @param theNeighbors of the current position of the vehicle.
     * @return the direction the vehicle is to move.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction result = Direction.EAST;
        final Direction direction = super.getDirection();
        final Terrain straight = theNeighbors.get(direction);
        final Terrain left = theNeighbors.get(direction.left());
        final Terrain right = theNeighbors.get(direction.right());

        if (straight == Terrain.STREET || straight == Terrain.LIGHT) {
            result = direction;
        } else if (left == Terrain.STREET || left == Terrain.LIGHT) {
            result = direction.left();
        } else if (right == Terrain.STREET || right == Terrain.LIGHT) {
            result = direction.right();
        } else {
            result = direction.reverse();
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
