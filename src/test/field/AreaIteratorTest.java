package field;

import org.junit.Test;
import structures.Position;
import java.util.Iterator;
import static org.junit.Assert.*;

public class AreaIteratorTest {
    @Test
    public void iterator() throws Exception {

        int width=8;
        int height=12;
        Iterator<Position> iterator = new AreaIterator(8,12);

        assertTrue("Itarator has not next",iterator.hasNext());
        for(int y=0;y<height;y++)
            for(int x=0;x<width;x++){
                assertTrue("Itarator has not next",iterator.hasNext());
                assertEquals(new Position(x,y),iterator.next());
            }

        assertFalse("Iterator has next",iterator.hasNext());
    }
}