package settings;

public class PlayerSettings{
    private final String name;
    private final int id;

    private int snippets;
    private int bombs;

    public PlayerSettings(String name) {
        this.name = name;
        this.id = Integer.valueOf(name.substring(name.length()-1));
    }

    void parse(String key, String value) {
        switch (key) {
            case "bombs":
                bombs = Integer.parseInt(value);
                break;
            case "snippets":
                snippets = Integer.parseInt(value);
                break;
            default:
                System.err.println(String.format("Cannot parse " + key));
        }
    }

    String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    int getSnippets() {
        return snippets;
    }

    int getBombs() {
        return bombs;
    }
}
