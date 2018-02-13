package settings;

import field.Field;
import field.FieldParser;

class CurrentSettings {
    private int round;
    private Field field;
    private final StartSettings startSettings;

    CurrentSettings(StartSettings startSettings) {
        this.startSettings = startSettings;
    }

    void parse(String key, String value) {
        switch(key) {
            case "round":
                round=Integer.parseInt(value);
                break;
            case "field":
                FieldParser fieldParser=new FieldParser(startSettings.getWidth(),startSettings.getHeight());
                this.field=fieldParser.parse(value);
                break;
            default:
                System.err.println(String.format(
                        "Cannot parse game data input with key '%s'", key));
        }
    }

    int getRound() {
        return round;
    }

    Field getField() {
        return field;
    }
}
