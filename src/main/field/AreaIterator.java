package field;

import structures.Position;

import java.util.Iterator;
import java.util.NoSuchElementException;

class AreaIterator implements Iterator<Position> {

    private final Position bottomRight;

    private Position index;

    public AreaIterator(int width,int height) {
        this.bottomRight = new Position(width-1,height-1);
        this.index=new Position(-1,0);
    }

    @Override
    public boolean hasNext() {
        return index.smallerOrEqual(bottomRight) && !index.equals(bottomRight);
    }

    @Override
    public Position next() {
        if(index.x < bottomRight.x){
            index = new Position(index.x+1,index.y);
            return index;
        }else if(index.y < bottomRight.y){
            index = new Position(0,index.y+1);
            return index;
        }else
            throw new NoSuchElementException("AreaTable iterator doesn't have next position");
    }
}
