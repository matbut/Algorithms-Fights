package field;

import positionObject.Snippet;
import positionObject.directionObject.Player;
import structures.*;

import java.util.*;

public class Field {
    final Area area;
    final int width;
    final int height;

    HashMap<Position,Snippet> snippets;
    HashMap<Position,Player> players;

    Field(int width, int height)  {
        this.area=new Area();
        this.height=height;
        this.width=width;
        this.snippets=new HashMap<>();
        this.players=new HashMap<>();
    }

    public Vertex getVertex(Position position) {
        return area.getVertex(position);
    }

    @Override
    public String toString() {
        String lineSeparator=System.getProperty("line.separator");

        StringBuilder strBuilder=new StringBuilder();

        for(Iterator<Position> iterator = new AreaIterator(width,height); iterator.hasNext();){
            Position position=iterator.next();
            String add="";
            if(area.isPositionValid(position)) {
                boolean signed = false;
                if(area.isLeftGate(position)) {
                    add += "Gl";
                    signed=true;
                }else if (area.isRightGate(position)){
                    add += "Gr";
                    signed=true;
                }
                if(isSnippetPosition(position)) {
                    add += "C";
                    signed = true;
                }
                if(isPlayerPosition(position)){
                    add += "P";
                    signed = true;
                }


                if(!signed)
                    add += ".";
            }else
                add+="x";

            if(iterator.hasNext())
                add+=",";

            strBuilder.append(add);
        }
        return strBuilder.toString();
    }

    public boolean isPlayerPosition(Position position) {
        return players.containsKey(position);
    }

    public boolean isSnippetPosition(Position position) {
        return snippets.containsKey(position);
    }

    public Collection<Position> getNeighbours(Position currentPosition) {
        return area.getNeighbours(currentPosition);
    }

    public Position getMiddlePosition() {
        return new Position(width/2,height/2);
    }

    public boolean isMiddlePosition(Position position){
        return getMiddlePosition().equals(position);
    }

    public MoveType getMoveType(Position start, Position copyGotFrom) {
        return area.getMoveType(start,copyGotFrom);
    }

    void addPlayer(Player player) {
        players.put(player.getPosition(),player);
    }

    void addSnippet(Snippet snippet) {
        snippets.put(snippet.getPosition(),snippet);
    }
}
