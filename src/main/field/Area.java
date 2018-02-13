
package field;

import structures.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

class Area {

    private HashMap<Position,Vertex> vertexes;
    private Vertex rightGate=null;
    private Vertex leftGate=null;

    Area() {
        this.vertexes=new HashMap<>();
    }

    void addVertex(String cellString,Position position){
        if(cellString.equals("x"))
            return;

        Vertex vertex = new Vertex(position);
        vertexes.put(vertex.position,vertex);

        switch (cellString) {
            case "Gl": {
                leftGate = vertex;
                break;
            }case "Gr": {
                rightGate = vertex;
                break;
            }
        }

    }

    void addNeighbours(){
        for(Vertex vertex : vertexes.values()){
            MoveType.valuesMovable().stream()
                    .map(mt -> vertex.position.translate(mt))
                    .filter(p -> vertexes.containsKey(p))
                    .map(p -> vertexes.get(p))
                    .forEach(vertex::addNeighbour);
        }

        rightGate.addNeighbour(MoveType.RIGHT,leftGate);
        leftGate.addNeighbour(MoveType.LEFT,rightGate);
    }

    @Override
    public String toString() {
        return vertexes.values().toString();
    }

    boolean isRightGate(Position position) {
        return rightGate.position.equals(position);
    }

    boolean isLeftGate(Position position) {
        return leftGate.position.equals(position);
    }

    boolean isPositionValid(Position position){
        return vertexes.containsKey(position);
    }

    Vertex getVertex(Position position) {
        return vertexes.get(position);
    }

    boolean isPossibleMove(Position from, Position to) {
        return vertexes.get(from).getNeighbours().stream()
                .anyMatch(v -> v.position.equals(to));
    }

    Collection<Position> getNeighbours(Position currentPosition) {
        return vertexes.get(currentPosition).getNeighbours().stream()
                .map(v -> v.position).collect(Collectors.toSet());
    }

    MoveType getMoveType(Position from,Position to){
        return vertexes.get(from).getMoveTypeTo(vertexes.get(to));
    }
}