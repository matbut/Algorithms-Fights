package positionObject;

import structures.Position;

public abstract class AbstractPositionObject {
    Position currentPosition;

    public AbstractPositionObject(Position position) {
        this.currentPosition=position;
    }

    public Position getPosition() {
        return currentPosition;
    }

    @Override
    public String toString() {
        return currentPosition.toString();
    }
}
