package structures;

import org.junit.Test;
import static org.junit.Assert.*;
import static structures.MoveType.*;

public class VectorTest {
    private static final double DELTA = 1e-15;

    @Test
    public void isParallel() throws Exception {

        Vector vector = new Vector(new Position(3,4));

        assertTrue(vector.isParallel(new Vector(new Position(-3,-4))));
        assertTrue(vector.isParallel(vector));
    }

    @Test
    public void freeVector() throws Exception {
        Vector vector=new Vector(new Position(1,2),new Position(4,7));
        assertEquals(new Vector(new Position(3,5)),vector.freeVector());
        vector=new Vector(new Position(5,7));
        assertEquals(new Vector(new Position(5,7)),vector.freeVector());
    }

    @Test
    public void length() throws Exception {
        Vector vector1=new Vector(new Position(10,5));
        Vector vector2=new Vector(new Position(5,10));
        assertEquals(vector1.length(),vector2.length(),DELTA);

        vector1=new Vector(new Position(2,3),new Position(10,5));
        vector2=new Vector(new Position(5,10),new Position(3,2));
        assertEquals(vector1.length(),vector2.length(),DELTA);

    }

    @Test
    public void add() throws Exception {
        Vector vector1=new Vector(new Position(10,3));
        Vector vector2=new Vector(new Position(5,7));
        assertEquals(new Vector(new Position(15,10)),vector1.add(vector2));
    }

    @Test
    public void scalarProduct() throws Exception {
        Vector vector=new Vector(new Position(1,2),new Position(3,3));
        assertEquals(new Vector(new Position(1,2),new Position(7,5)),vector.scalarProduct(3));
        assertEquals(vector,vector.scalarProduct(1));
    }

    @Test
    public void toMoveType() throws Exception {
        Vector vector=new Vector(new Position(3,3),new Position(3,3));
        assertEquals(PASS,vector.toMoveType());

        vector=new Vector(new Position(3,3),new Position(3,4));
        assertEquals(DOWN,vector.toMoveType());

        vector=new Vector(new Position(3,3),new Position(4,3));
        assertEquals(RIGHT,vector.toMoveType());

        vector=new Vector(new Position(3,3),new Position(2,3));
        assertEquals(LEFT,vector.toMoveType());

        vector=new Vector(new Position(3,3),new Position(3,2));
        assertEquals(UP,vector.toMoveType());
    }

}