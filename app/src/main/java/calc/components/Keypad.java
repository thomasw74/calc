package calc.components;

import javafx.scene.layout.GridPane;

public final class Keypad extends GridPane {
    public Keypad() {
        add(new TextKey("("), 0, 0);
        add(new TextKey(")"), 1, 0);
        add(new DeleteKey(), 3, 0);
        add(new TextKey("7"), 0, 1);
        add(new TextKey("8"), 1, 1);
        add(new TextKey("9"), 2, 1);
        add(new TextKey("/"), 3, 1);
        add(new TextKey("4"), 0, 2);
        add(new TextKey("5"), 1, 2);
        add(new TextKey("6"), 2, 2);
        add(new TextKey("*"), 3, 2);
        add(new TextKey("1"), 0, 3);
        add(new TextKey("2"), 1, 3);
        add(new TextKey("3"), 2, 3);
        add(new TextKey("-"), 3, 3);
        add(new TextKey("0"), 0, 4);
        add(new CalculateKey(), 2, 4);
        add(new TextKey("+"), 3, 4);
    }
}
