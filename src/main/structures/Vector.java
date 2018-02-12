package structures;

import java.util.Arrays;
import java.util.Optional;

/**
 * Represents vector
 *
 */
public class Vector implements Comparable<Vector>{
    public final Position from;
    public final Position to;

    public Vector(Position from, Position to) {
        this.from = from;
        this.to = to;
    }

    public Vector(Position to) {
        this.from = new Position(0,0);
        this.to = to;
    }

    public Vector freeVector(){
        return new Vector(this.to.sub(this.from));
    }

    public double length(){
        return from.distance(to);
    }

    public Vector add(Vector other){
        return new Vector(this.from,this.to.translate(other));
    }

    public Vector scalarProduct(int skalar){
        Vector product=this;
        for(int i=1;i<skalar;i++){
            product=product.add(this);
        }
        return product;
    }

    public boolean isParallel(Vector other){
        return this.determinant(other)==0;
    }

    public MoveType toMoveType(){
        Optional<MoveType> moveTypeOptional =
                Arrays.stream(MoveType.values())
                        .filter(mt -> mt.getMoveTypeVector().equals(this.freeVector()))
                        .findAny();
        if(moveTypeOptional.isPresent())
            return moveTypeOptional.get();
        else
            throw new UnsupportedOperationException("Can't convert " + this + "to MoveType");
    }

    @Override
    public int compareTo(Vector other) {
        return Double.compare(this.length(),other.length());
    }

    @Override
    public String toString() {
        return "[" + from + "," + to + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector)) return false;

        Vector vector = (Vector) o;

        if (!from.equals(vector.from)) return false;
        return to.equals(vector.to);
    }

    @Override
    public int hashCode() {
        int result = from.hashCode();
        result = 31 * result + to.hashCode();
        return result;
    }

    private int determinant(Vector other){
        Vector vector=this.freeVector();
        other=other.freeVector();

        return (vector.to.x*other.to.y) - (vector.to.y*other.to.x);
    }
}
