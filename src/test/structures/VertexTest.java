package structures;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;
import static structures.MoveType.*;

public class VertexTest {
    @Test
    public void getMoveTypeTo() throws Exception {
    }

    @Test
    public void neighbour() throws Exception {
        Vertex vertex=new Vertex(new Position(1,1));
        HashSet<Vertex> hashSet = new HashSet<>();

        vertex.addNeighbour(new Vertex(new Position(1,2)));
        hashSet.add(new Vertex(new Position(1,2)));

        vertex.addNeighbour(LEFT,new Vertex(new Position(10,10)));
        hashSet.add(new Vertex(new Position(10,10)));
        assertEquals(hashSet,vertex.getNeighbours());
    }

    @Test
    public void isCrossing() throws Exception {
        Vertex vertex=new Vertex(new Position(10,10));
        assertFalse(vertex.isCrossing());
        vertex.addNeighbour(new Vertex(new Position(9,10)));
        assertFalse(vertex.isCrossing());
        vertex.addNeighbour(new Vertex(new Position(10,11)));
        assertFalse(vertex.isCrossing());
        vertex.addNeighbour(new Vertex(new Position(10,9)));
        assertTrue(vertex.isCrossing());
    }

    @Test
    public void isCorridor() throws Exception {
        Vertex vertex=new Vertex(new Position(10,10));
        assertFalse(vertex.isCorridor());
        vertex.addNeighbour(new Vertex(new Position(9,10)));
        assertFalse(vertex.isCorridor());
        vertex.addNeighbour(new Vertex(new Position(10,11)));
        assertFalse(vertex.isCorridor());

        vertex=new Vertex(new Position(10,10));
        assertFalse(vertex.isCorridor());
        vertex.addNeighbour(new Vertex(new Position(10,9)));
        assertFalse(vertex.isCorridor());
        vertex.addNeighbour(new Vertex(new Position(10,11)));
        assertTrue(vertex.isCorridor());
        vertex.addNeighbour(new Vertex(new Position(9,10)));
        assertFalse(vertex.isCorridor());
    }

    @Test
    public void isCurve() throws Exception {
        Vertex vertex=new Vertex(new Position(10,10));
        assertFalse(vertex.isCurve());
        vertex.addNeighbour(new Vertex(new Position(9,10)));
        assertFalse(vertex.isCurve());
        vertex.addNeighbour(new Vertex(new Position(10,11)));
        assertTrue(vertex.isCurve());

        vertex=new Vertex(new Position(10,10));
        assertFalse(vertex.isCurve());
        vertex.addNeighbour(new Vertex(new Position(10,9)));
        assertFalse(vertex.isCurve());
        vertex.addNeighbour(new Vertex(new Position(10,11)));
        assertFalse(vertex.isCurve());
    }

}