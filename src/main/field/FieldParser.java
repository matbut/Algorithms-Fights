package field;

import positionObject.Snippet;
import positionObject.directionObject.Player;
import settings.PlayerSettings;
import structures.Position;

import java.util.Collection;
import java.util.Iterator;

public class FieldParser {
    private final Field field;
    private PlayerSettings[] playerSettings= new PlayerSettings[2];

    public FieldParser(int width, int height, Collection<PlayerSettings> playerSettings) {
        this.field = new Field(width,height);
        playerSettings.forEach(ps -> this.playerSettings[ps.getId()]=ps);
    }

    public Field parse(String input){

        String[] cells = input.split(",");

        Iterator<Position> iterator=new AreaIterator(field.width,field.height);
        for (String cellString : cells) {
            Position position=iterator.next();

            for (String cellPart : cellString.split(";")) {
                field.area.addVertex(cellPart,position);
                switch (cellPart.charAt(0)) {
                    case 'P':
                        parsePlayerCell(cellPart.charAt(1),position);
                        break;
                    case 'e':
                        parseSpawnPoint(cellPart.charAt(1),position);
                        break;
                    case 'E':
                        parseBugCell(cellPart.charAt(1), position);
                        break;
                    case 'B':
                        parseMineCell(cellPart, position);
                        break;
                    case 'C':
                        parseSnippetCell(position);
                        break;
                }
            }
        }
        field.area.addNeighbours();
        return this.field;
    }

    /**
     * Stores the position of one of the players, given by the id
     * @param type of bug spawn
     * @param position -position
     */
    private void parseSpawnPoint(char type, Position position) {
    }

    /**
     * Stores the position of one of the players, given by the id
     * @param id Player ID
     * @param position -position
     */
    private void parsePlayerCell(char id,Position position){
        int intId=Character.getNumericValue(id);
        field.addPlayer(new Player(position,playerSettings[intId]));
    }

    /**
     * Stores the position of an enemy. The type of enemy AI
     * is also given, but not stored in the starterbot.
     * @param type Type of bug AI
     * @param position -position
     */
    private void parseBugCell(char type, Position position){

    }

    /**
     * Stores the position of a bomb that can be collected or is
     * about to explode. The amount of ticks is not stored
     * in this starterbot.
     * @param cell The string that represents a bomb, if only 1 letter it
     *             can be collected, otherwise it will contain a number
     *             2 - 5, that means it's ticking to explode in that amount
     *             of rounds.
     * @param position -position
     */
    private void parseMineCell(String cell, Position position) {

    }

    /**
     * Stores the position of a snippet
     * @param position - position
     */
    private void parseSnippetCell(Position position) {
        field.addSnippet(new Snippet(position));
    }

}
