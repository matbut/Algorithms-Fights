package settings;

import java.util.HashMap;
import java.util.NoSuchElementException;

class StartSettings{
    private final String character="bixie";

    private int timebank;
    private int timePerMove;
    private int maxRounds;
    private int width;
    private int height;

    private String myName;
    private String opponentName;
    private HashMap<String,PlayerSettings> playersSettings=new HashMap<>();

    void parse(String key, String value) {
        switch(key) {
            case "timebank":
                timebank = Integer.parseInt(value);
                break;
            case "time_per_move":
                timePerMove = Integer.parseInt(value);
                break;
            case "player_names":
                String[] playerNames = value.split(",");
                myName =playerNames[0];
                opponentName =playerNames[1];
                playersSettings.put(myName,new PlayerSettings(myName));
                playersSettings.put(opponentName,new PlayerSettings(opponentName));
                break;
            case "your_bot":
                if(!myName.equals(value)){
                    String tmp=myName; myName=opponentName; opponentName=tmp;
                }
                break;
            case "your_botid":
                break;
            case "field_width":
                width=Integer.parseInt(value);
                break;
            case "field_height":
                height=Integer.parseInt(value);
                break;
            case "max_rounds":
                maxRounds=Integer.parseInt(value);
                break;
            default:
                System.err.println(String.format(
                        "Cannot parse settings input with key '%s'", key));
        }
    }

    int getTimebank() {
        return timebank;
    }

    int getTimePerMove() {
        return timePerMove;
    }

    int getMaxRounds() {
        return maxRounds;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    PlayerSettings getMyPlayerSettings() {
        return playersSettings.get(myName);
    }

    PlayerSettings getOpponentPlayerSettings() {
        return playersSettings.get(opponentName);
    }

    PlayerSettings getPlayerSettings(String playerName) {
        return playersSettings.get(playerName);
    }

    PlayerSettings getPlayerSettings(int id) {
        if (getMyPlayerSettings().getId()==id)
            return getMyPlayerSettings();
        else if (getOpponentPlayerSettings().getId()==id)
            return getOpponentPlayerSettings();
        else
            throw new NoSuchElementException("Can't find player with id "+id);
    }

    String getCharacter() {
        return character;
    }
}
