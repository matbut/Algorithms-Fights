package positionObject.directionObject;

import positionObject.AbstractPositionObject;
import structures.MoveType;
import structures.Position;

public abstract class AbstractDirectionObject extends AbstractPositionObject{
    protected MoveType direction;

    public AbstractDirectionObject(Position position) {
        super(position);
    }

    public void setDirection(MoveType direction) {
        this.direction = direction;
    }

    public MoveType getDirection() {
        return direction;
    }
}
