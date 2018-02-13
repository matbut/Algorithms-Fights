package settings;



import java.util.Scanner;

/**
 *
 */
public class GameSettings {
    private static final GameSettings instance = new GameSettings();

    private Scanner scanner;
    private CurrentSettings currentSettings;
    private StartSettings startSettings;

    private GameSettings() {
        scanner = new Scanner(System.in);
        startSettings=new StartSettings();
        currentSettings = new CurrentSettings(startSettings);
    }

    public static GameSettings getInstance() {
        return instance;
    }

    public void parse() {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.length() == 0) continue;

            String[] parts = line.split(" ");
            switch (parts[0]) {
                case "settings":
                    startSettings.parse(parts[1], parts[2]);
                    break;
                case "update":
                    if (parts[1].equals("game")) {
                        currentSettings.parse(parts[2], parts[3]);
                    } else {
                        startSettings.getPlayerSettings(parts[1]).parse(parts[2], parts[3]);
                    }
                    break;
                case "action":
                    if (parts[1].equals("character")) {
                        System.out.println(startSettings.getCharacter());
                    } else if (parts[1].equals("move")) {

                        //Move move = new Move(currentSettings.getField().getMe(),currentSettings.getField());
                        //System.out.println(move.getMove());

                    }
                    break;
                default:
                    System.err.println("Unknown command");
                    break;
            }
        }
    }

    public PlayerSettings getPlayerSettings(int id) {
        return  startSettings.getPlayerSettings(id);
    }

    public PlayerSettings getMyPlayerSettings() {
        return startSettings.getMyPlayerSettings();
    }

    public PlayerSettings getOpponentPlayerSettings() {
        return startSettings.getMyPlayerSettings();
    }

    public int getWidth() {
        return startSettings.getWidth();
    }

    public int getHeight() {
        return startSettings.getHeight();
    }
}
