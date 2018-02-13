package field;

import org.junit.Test;
import structures.Position;

import java.util.Iterator;

import static org.junit.Assert.*;

public class AreaTest {
    private Area area=createTestArea();

    public Area createTestArea(){

        String stringArea =
                //                            1 1 1 1 1 1 1 1 1
                //......  0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8
                /*  0 */ ".,.,.,x,.,.,.,.,.,.,.,.,.,.,.,x,.,.,.," +
                /*  1 */ ".,x,.,x,.,x,x,x,x,.,x,x,x,x,.,x,.,x,.," +
                /*  2 */ ".,x,.,.,.,x,.,.,.,.,.,.,.,x,.,.,.,x,.," +
                /*  3 */ ".,x,x,x,.,x,.,x,x,x,x,x,.,x,.,x,x,x,.," +
                /*  4 */ ".,x,.,.,.,x,.,.,.,.,.,.,.,x,.,.,.,x,.," +
                /*  5 */ ".,.,.,x,.,x,.,x,x,.,x,x,.,x,.,x,.,.,.," +
                /*  6 */ "x,.,x,x,.,.,.,x,x,.,x,x,.,.,.,x,x,.,x," +
                /*  7 */ ".,.,x,x,.,x,x,x,x,.,x,x,x,x,.,x,x,.,.," +
                /*  8 */ "x,.,x,x,.,.,.,.,.,.,.,.,.,.,.,x,x,.,x," +
                /*  9 */"Gl,.,.,x,.,x,x,x,x,x,x,x,x,x,.,x,.,.,Gr," +
                /* 10 */ ".,x,.,.,.,.,.,.,x,x,x,.,.,.,.,.,.,x,.," +
                /* 11 */ ".,x,.,x,x,.,x,.,.,.,.,.,x,.,x,x,.,x,.," +
                /* 12 */ ".,x,.,x,x,.,x,x,x,x,x,x,x,.,x,x,.,x,.," +
                /* 13 */ ".,x,.,x,x,.,x,.,.,.,.,.,x,.,x,x,.,x,.," +
                /* 14 */ ".,.,.,.,.,.,.,.,x,x,x,.,.,.,.,.,.,.,.";

        int width=19;
        int height=15;

        Iterator<Position> positionIterator = new AreaIterator(width,height);
        Area areaVertex = new Area();


        for (String cellString : stringArea.split(",")){
            Position position = positionIterator.next();
            areaVertex.addVertex(cellString,position);
        }
        areaVertex.addNeighbours();
        return areaVertex;
    }

    @Test
    public void areaVertexTest() throws Exception {
        //System.out.println(area.toString());
    }

    @Test
    public void addVertex() throws Exception {
    }

    @Test
    public void addNeighbours() throws Exception {
    }

    @Test
    public void isRightGate() throws Exception {
    }

    @Test
    public void isLeftGate() throws Exception {
    }

    @Test
    public void isPositionValid() throws Exception {
    }

    @Test
    public void getVertex() throws Exception {
    }

    @Test
    public void isPossibleMove() throws Exception {
    }

    @Test
    public void getNeighbours() throws Exception {
    }

    @Test
    public void getMoveType() throws Exception {
    }

}