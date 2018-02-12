package structures;

/**
 *
 */
public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean smallerOrEqual(Position other){
        return ((this.x <= other.x) && (this.y <= other.y));
    }

    public boolean largerOrEqual(Position other){
        return this.x >= other.x && this.y >= other.y;
    }

    public Position sub(Position other){
        return new Position(this.x-other.x,this.y-other.y);
    }

    public Position add(Position other){
        return new Position(this.x+other.x,this.y+other.y);
    }

    public Position translate(Vector vector){
        return this.add(vector.freeVector().to);
    }

    public Position translate(MoveType moveType){
        return this.translate(moveType.getMoveTypeVector());
    }

    public double distance(Position other){
        return Math.sqrt(Math.pow((double)(this.x-other.x),2.0)+Math.pow((double)(this.y-other.y),2.0));
    }

    public MoveType getMoveTypeTo(Position to){
        Vector vector = new Vector(this,to);
        return vector.toMoveType();
    }

    @Override
    public String toString() {
        return "("  + x + "," + y + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
