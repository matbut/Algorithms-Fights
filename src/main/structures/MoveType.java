package structures;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 *
 */
public enum MoveType {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    PASS;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

    public Vector getMoveTypeVector() {
        switch (this){
            case PASS:
                return new Vector(new Position(0,0));
            case UP:
                return new Vector(new Position(0,-1));
            case DOWN:
                return new Vector(new Position(0,1));
            case LEFT:
                return new Vector(new Position(-1,0));
            case RIGHT:
                return new Vector(new Position(1,0));
            default:
                return PASS.getMoveTypeVector();
        }
    }

    public MoveType getParalell(){
        switch (this){
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case RIGHT:
                return LEFT;
            case LEFT:
                return RIGHT;
            default:
                return PASS;
        }
    }

    public static Collection<MoveType> valuesMovable(){
        return Arrays.stream(values()).filter(mt -> mt!=PASS).collect(Collectors.toSet());
    }
}
