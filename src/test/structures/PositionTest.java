package structures;

import org.junit.Test;
import static org.junit.Assert.*;
import static structures.MoveType.*;

public class PositionTest {
    private static final double DELTA = 1e-15;

    @Test
    public void distance() throws Exception {
        Position position = new Position(10,5);
        Position other = new Position(5,10);
        assertEquals(position.distance(new Position(0,0)),other.distance(new Position(0,0)),DELTA);

        position=new Position(2,3);
        other=new Position(5,10);
        assertEquals(position.distance(other),other.distance(position),DELTA);
    }

    @Test
    public void getMoveTypeTo() throws Exception {
        Position position=new Position(2,3);
        assertEquals(RIGHT,position.getMoveTypeTo(new Position(3,3)));
        assertEquals(UP,position.getMoveTypeTo(new Position(2,2)));
        assertEquals(PASS,position.getMoveTypeTo(new Position(2,3)));
    }

    @Test
    public void smallerOrEqual() throws Exception {
        Position position = new Position(3,4);
        assertTrue(position.smallerOrEqual(new Position(3,4)));
        assertTrue(position.smallerOrEqual(new Position(3,5)));
        assertTrue(position.smallerOrEqual(new Position(10,11)));
        assertFalse(position.smallerOrEqual(new Position(2,10)));
    }

    @Test
    public void largerOrEqual() throws Exception {
        Position position = new Position(3,4);

        assertTrue(position.largerOrEqual(new Position(3,4)));
        assertTrue(position.largerOrEqual(new Position(3,3)));
        assertTrue(position.largerOrEqual(new Position(0,1)));
        assertFalse(position.largerOrEqual(new Position(2,10)));
    }

    @Test
    public void sub() throws Exception {
        Position pos1 = new Position(1,3);
        Position pos2 = new Position(4,2);
        assertEquals(new Position(-3,1),pos1.sub(pos2));
    }

    @Test
    public void add() throws Exception {
        Position pos1 = new Position(1,3);
        Position pos2 = new Position(4,2);
        assertEquals(new Position(5,5),pos1.add(pos2));
    }

    @Test
    public void translate() throws Exception {
        Position pos1 = new Position(1,3);
        Position pos2 = new Position(4,2);
        assertEquals(new Position(2,5),pos1.translate(new Vector(new Position(1,2))));
        assertEquals(pos1,pos1.translate(new Vector(new Position(0,0))));
    }

    @Test
    public void translate2() throws Exception {
        Position pos1 = new Position(1,3);
        Position pos2 = new Position(4,2);
        assertEquals(new Position(0,3),pos1.translate(LEFT));
        assertEquals(new Position(4,3),pos2.translate(DOWN));
        assertEquals(pos1,pos1.translate(PASS));
        assertEquals(pos2,pos2.translate(PASS));
    }

}