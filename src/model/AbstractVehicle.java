/*
 * TCSS 305 - AbstractVehicle
 * 
 */
package model;


/**
 * Abstract class AbstractVehicle.
 * 
 * @author mohibkohi.
 * @version 1.0.
 *
 */
public abstract class AbstractVehicle implements Vehicle {
    
    /**X location of the vehicle.*/
    private int myX;
    
    /**Y location of the vehicle.*/
    private int myY;
    
    /**Direction the vehicle is facing.*/
    private Direction myDirection;
    
    /**Name of the Vehicle.*/
    private String myVehicleName;
    
    /**Count how many times vehicle is being poked.*/
    private int myCountPokes;
    
    /**Field to check when vehicle is dead or alive.*/
    private boolean myAlive;
    
    /**Initial x position of 2my vehicle.*/
    private final int myInitialX; 
    
    /**Initial y position of my vehicle.*/
    private final int myInitialY;
    
    /**Initial position of my vehicle.*/
    private final Direction myInitialDirection;
    
    /**Death time of each vehicle.*/
    private int myDeathTime;
    
    /**
     * Constructor AbstractVehicle initializes instance fields. 
     * 
     * @param theX location of the Vehicle.
     * @param theY location of the Vehicle.
     * @param theDir direction of the Vehicle.
     * @param theString name of the Vehicle.
     * @param theDeathTime of the Vehicle.
     */
    protected AbstractVehicle(final int theX, final int theY, 
            final Direction theDir, final String theString, final int theDeathTime) {
        myX = theX;
        myY = theY;
        myDirection = theDir;
        myInitialX = theX;
        myInitialY = theY;
        myInitialDirection = theDir;
        myVehicleName = theString;
        myDeathTime = theDeathTime;
        myAlive = true;
    }  

    /**
     * A command that notifies this vehicle that it has collided 
     * with the given other Vehicle.
     * @param theOther vehicle which collided.
     */
    @Override
    public void collide(final Vehicle theOther) { 
        if (theOther.getDeathTime() < getDeathTime()) {
            myAlive = false;
        }
    }

    /**
     * A query that returns the number of updates between this 
     * vehicle's death and when it should revive.
     * @return the vehicles death time.
     */
    @Override
    public int getDeathTime() {
        return myDeathTime;
    }

    /**
     * A query that returns the name of the image file that the GUI will
     * use to draw this Vehicle.
     * @return name of the vehicle
     */
    @Override
    public String getImageFileName() {
        String result = myVehicleName + ".gif";
        if (!isAlive()) {
            result = myVehicleName + "_dead.gif";
        }
        return result;
    }

    /**
     * A query that returns the direction this vehicle is facing.
     * @return vehicle's direction. 
     */
    @Override
    public Direction getDirection() {
        return myDirection;
    }

    /**
     * Queries that return the x coordinate of this vehicle.
     * @return vehicle's x location. 
     */
    @Override
    public int getX() {
        return myX;
    }

    /**
     * Queries that return the y coordinate of this vehicle.
     * @return vehicle's y location. 
     */
    @Override
    public int getY() {
        return myY;
    }

    /**
     * A query that returns whether this vehicle is alive.
     * @return true if alive false other wise.
     */
    @Override
    public boolean isAlive() {
        return myAlive;
    }

    /**
     * A command called by the graphical user interface once 
     * for each time the city animates one turn.
     */
    @Override
    public void poke() {
        myCountPokes++;
        if (myCountPokes == getDeathTime()) {
            myAlive = true;
            myCountPokes = 0;
            myDirection = Direction.random();
        }  
    }

    /**
     * A command that instructs this Vehicle to return to the initial state.
     */
    @Override
    public void reset() {
        myDirection = myInitialDirection;
        myX = myInitialX;
        myY = myInitialY; 
        myAlive = true; 
    }

    /**
     * A command that sets the movement direction of this vehicle.
     * @param theDir the vehicle should be facing. 
     */
    @Override
    public void setDirection(final Direction theDir) {
        myDirection = theDir;
    }

    /**
     * Commands that set the x coordinate of this Vehicle.
     * @param theX location the vehicle.
     */
    @Override
    public void setX(final int theX) {
        myX = theX;
    }

    /**
     * Commands that set the y coordinate of this Vehicle.
     * @param theY location the vehicle.
     */
    @Override
    public void setY(final int theY) {
        myY = theY;
    }
    
    /**
     * ToString prints the name of the current vehicle.
     * @return vehicle name.
     */
    @Override
    public String toString() {
        return myVehicleName;
    }
}
