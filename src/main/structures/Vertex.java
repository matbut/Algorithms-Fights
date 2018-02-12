package structures;

import java.util.*;

/**
 * Represents graph vertex - position with neighbours.
 */

public class Vertex {
    public final Position position;
    private HashMap<Vertex,MoveType> neighbours;

    public Vertex(Position position) {
        this.neighbours = new HashMap<>();
        this.position=position;
    }

    public MoveType getMoveTypeTo(Vertex vertex){
        if(neighbours.containsKey(vertex))
            return neighbours.get(vertex);
        else
            throw new NoSuchElementException("Cant find " + vertex + " in " + this + "neighbours");
    }

    public Collection<Vertex> getNeighbours() {
        return neighbours.keySet();
    }

    public void addNeighbour(Vertex neighbour){
        neighbours.put(neighbour,position.getMoveTypeTo(neighbour.position));
    }

    public void addNeighbour(MoveType moveType,Vertex neighbour){
        neighbours.put(neighbour,moveType);
    }

    public boolean isCrossing(){
        return neighbours.size()>2;
    }

    public boolean isCorridor(){
        if(neighbours.size()!=2)
            return false;

        Iterator<MoveType> iterator= neighbours.values().iterator();
        MoveType moveType1 = iterator.next();
        MoveType moveType2 = iterator.next();

        return moveType1.getParalell()==moveType2;
    }

    public boolean isCurve(){
        return neighbours.size()==2 && !isCrossing() && !isCorridor();
    }

    @Override
    public String toString() {
        String lineSeparator=System.getProperty("line.separator");
        StringBuilder strBuilder=new StringBuilder(lineSeparator+"Vertex{"+position);
        for(Vertex vertex : neighbours.keySet())
            strBuilder.append(neighbours.get(vertex)+"-"+vertex.position);
        return strBuilder.toString()+"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;

        Vertex vertex = (Vertex) o;
        return position.equals(vertex.position);
    }

    @Override
    public int hashCode() {
        return position.hashCode();
    }
}
