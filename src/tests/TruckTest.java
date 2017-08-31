/**
 * TCCS 305: TruckTest
 */
package tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import model.Direction;
import model.Light;
import model.Terrain;
import model.Truck;

import org.junit.Test;

/**
 * @author mohibkohi
 * @version 1.0
 *
 */
public class TruckTest {

    /**
     * Test method for {@link model.Truck#Truck(int, int, model.Direction)}.
     */
    @Test
    public void testTruckConstructor() {
        final Truck t = new Truck(15, 12, Direction.NORTH);
        
        assertEquals("truck x coordinate not initialized correctly!", 15, t.getX());
        assertEquals("truck y coordinate not initialized correctly!", 12, t.getY());
        assertEquals("truck direction not initialized correctly!",
                     Direction.NORTH, t.getDirection());
        assertEquals("truck death time not initialized correctly!", 0, t.getDeathTime());
        assertTrue("truck isAlive() fails initially!", t.isAlive());
    }

    /**
     * Test method for {@link model.Truck#canPass(model.Terrain, model.Light)}.
     */
    @Test
    public void testCanPass() {
        final Truck t = new Truck(0, 0, Direction.SOUTH);
        assertTrue(t.canPass(Terrain.STREET, Light.RED));
        assertFalse(t.canPass(Terrain.WALL, Light.GREEN));
        assertTrue(t.canPass(Terrain.LIGHT, Light.RED));
        
    }

    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirection() {
        final Truck t = new Truck(0, 0, Direction.SOUTH);
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.WEST, Terrain.WALL);
        neighbors.put(Direction.NORTH, Terrain.WALL);
        neighbors.put(Direction.EAST, Terrain.WALL);
        neighbors.put(Direction.SOUTH, Terrain.STREET);
        assertEquals(Direction.SOUTH, t.chooseDirection(neighbors));
        neighbors.put(Direction.NORTH, Terrain.LIGHT);
        neighbors.put(Direction.SOUTH, Terrain.WALL);
        assertEquals(Direction.NORTH, t.chooseDirection(neighbors));
    }
    
    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionStreetTest() {
        final Truck t = new Truck(0, 0, Direction.SOUTH);
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.WEST, Terrain.WALL);
        neighbors.put(Direction.NORTH, Terrain.WALL);
        neighbors.put(Direction.EAST, Terrain.WALL);
        neighbors.put(Direction.SOUTH, Terrain.WALL);
        assertEquals(Direction.NORTH, t.chooseDirection(neighbors));
    }
    
    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirectionLightsTest() {
        final Truck t = new Truck(0, 0, Direction.SOUTH);
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.WEST, Terrain.WALL);
        neighbors.put(Direction.NORTH, Terrain.WALL);
        neighbors.put(Direction.EAST, Terrain.WALL);
        assertEquals(Direction.NORTH, t.chooseDirection(neighbors));
    }

    /**
     * Test method for {@link model.AbstractVehicle#collide(model.Vehicle)}.
     */
    @Test
    public void testCollide() {
        final Truck c = new Truck(0, 0, Direction.SOUTH);
        final Truck t = new Truck(0, 0, Direction.SOUTH);
        t.collide(c);
    }

    /**
     * Test method for {@link model.AbstractVehicle#getDeathTime()}.
     */
    @Test
    public void testGetDeathTime() {
        final Truck t = new Truck(0, 0, Direction.SOUTH);
        assertEquals(0, t.getDeathTime());
    }

    /**
     * Test method for {@link model.AbstractVehicle#getImageFileName()}.
     */
    @Test
    public void testGetImageFileName() {
        final Truck t = new Truck(0, 0, Direction.SOUTH);
        assertEquals("truck.gif", t.getImageFileName());
    }

    /**
     * Test method for {@link model.AbstractVehicle#setDirection(model.Direction)}.
     */
    @Test
    public void testSetDirectionSetXSetY() {
        final Truck t = new Truck(0, 0, Direction.SOUTH);
        t.setDirection(Direction.EAST);
        t.setX(2);
        t.setY(4);
        assertEquals(Direction.EAST, t.getDirection());
        assertEquals(2, t.getX());
        assertEquals(4, t.getY());
    }


    /**
     * Test method for {@link model.AbstractVehicle#poke()}.
     */
    @Test
    public void testPoke() {
        final Truck t = new Truck(0, 0, Direction.SOUTH);
        t.poke();
    }

    /**
     * Test method for {@link model.AbstractVehicle#reset()}.
     */
    @Test
    public void testReset() {
        final Truck t = new Truck(4, 8, Direction.SOUTH);
        t.setDirection(Direction.EAST);
        t.setX(2);
        t.setY(4);
        t.reset();
        assertEquals(Direction.SOUTH, t.getDirection());
        assertEquals(4, t.getX());
        assertEquals(8, t.getY());
        
    }
    
    /**
     * Test method for {@link model.Truck#toString()}.
     */
    @Test
    public void testToString() {
        final Truck t = new Truck(4, 8, Direction.SOUTH);
        final String s = "truck is at x: 4 y: 8 facing SOUTH";
        assertEquals(s, t.toString());
    }

}
