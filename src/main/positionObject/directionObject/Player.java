package positionObject.directionObject;

import settings.PlayerSettings;
import structures.Position;

public class Player extends AbstractDirectionObject{
    private final PlayerSettings playerSettings;

    public Player(Position position, PlayerSettings playerSettings) {
        super(position);
        this.playerSettings = playerSettings;
    }
}
